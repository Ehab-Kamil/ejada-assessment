package com.ejada.assessment.manager.impl;

import com.ejada.assessment.dto.BusinessruleDTO;
import com.ejada.assessment.dto.PaymentTransactionDTO;
import com.ejada.assessment.dto.PaymentTransactionWrapper;
import com.ejada.assessment.util.ConditionEvaluatorUtil;

import java.util.Map;
import java.util.concurrent.Callable;

import static com.ejada.assessment.util.Operators.EQUALS;
import static com.ejada.assessment.util.Operators.GREATER_THAN;
import static com.ejada.assessment.util.Operators.LESS_THAN;

/**
 * <p>
 * Title: PaymentRuleMatcher.java
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
public class PaymentRuleMatcherThread implements Callable {

    private Map<Integer, PaymentTransactionWrapper> map;
    private BusinessruleDTO rule;
    private PaymentTransactionDTO payment;
    private int ruleIndex;

    public PaymentRuleMatcherThread(Map<Integer, PaymentTransactionWrapper> map, int ruleIndex, BusinessruleDTO rule, PaymentTransactionDTO payment) {
        this.map = map;
        this.rule = rule;
        this.payment = payment;
        this.ruleIndex = ruleIndex;
    }

    @Override
    public Object call() throws Exception {
        boolean conditionResult = ConditionEvaluatorUtil.applyCondition(rule.getCondition(), this.payment);

        if (conditionResult) {
            map.put(ruleIndex, new PaymentTransactionWrapper(payment, true, rule));
        }
        else {
            map.put(ruleIndex, new PaymentTransactionWrapper(payment, false, rule));
        }
        return null;
    }

}
