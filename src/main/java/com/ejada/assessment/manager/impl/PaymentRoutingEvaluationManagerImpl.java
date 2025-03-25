package com.ejada.assessment.manager.impl;

import com.ejada.assessment.dto.BusinessruleDTO;
import com.ejada.assessment.dto.PaymentTransactionDTO;
import com.ejada.assessment.dto.PaymentTransactionWrapper;
import com.ejada.assessment.manager.PaymentEvaluationManager;
import com.ejada.assessment.service.BusinessRuleService;
import com.ejada.assessment.util.ActionApplyUtil;
import com.ejada.assessment.util.ConditionEvaluatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * Title: PaymentEvaluationManager.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright(c) Ehab Kamil, 2025
 * </p>
 *
 * @author <a href="mailto:ehabkamil2@gmail.com">Ehab Attia</a>
 * @version 1.0
 */
@Component
public class PaymentRoutingEvaluationManagerImpl implements PaymentEvaluationManager {

    @Autowired
    private BusinessRuleService businessRuleService;

    @Override
    public PaymentTransactionDTO evaluate(PaymentTransactionDTO payment) {

        //load all business rules, it should be cached somewhere
        List<BusinessruleDTO> rules = businessRuleService.getRoutingRulesOrderByPriority();

        BusinessruleDTO rule = rules.stream().filter((rule) -> {
            return ConditionEvaluatorUtil.applyCondition(rule.getCondition(), payment);
        }).max(Comparator.comparingInt(BusinessruleDTO::getPriority)).get();

        ActionApplyUtil.applyAction(result.getAction(), payment);
        payment.getAppliedRules().add(rule);

        return payment;
    }
}
