package com.ejada.assessment.manager.impl;

import com.ejada.assessment.dto.BusinessruleDTO;
import com.ejada.assessment.dto.PaymentTransactionDTO;
import com.ejada.assessment.dto.PaymentTransactionWrapper;
import com.ejada.assessment.manager.PaymentEvaluationManager;
import com.ejada.assessment.service.BusinessRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
public class PaymentEnrichmentEvaluationManagerImpl implements PaymentEvaluationManager {

    @Autowired
    private BusinessRuleService businessRuleService;

    @Override
    public PaymentTransactionDTO evaluate(PaymentTransactionDTO payment) {

        Map<Integer, PaymentTransactionWrapper> map = new ConcurrentHashMap<>();

        //load all business rules, it should be cached somewhere
        List<BusinessruleDTO> rules = businessRuleService.getEnrichmentRulesOrderByPriority();

        ExecutorService executor = Executors.newFixedThreadPool(rules.size() + 1);

        AtomicInteger ruleIndex = new AtomicInteger(1);

        rules.forEach((rule) -> {
            executor.submit(new PaymentRuleMatcherThread(map, ruleIndex.getAndIncrement(), rule, payment));
        });

        Future<PaymentTransactionDTO> future = executor.submit(new PaymentRuleExecutorThread(map, rules.size() , payment));

        try {
            return future.get();
        }
        catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
