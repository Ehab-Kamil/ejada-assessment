package com.ejada.assessment.manager.impl;

import com.ejada.assessment.dto.PaymentTransactionDTO;
import com.ejada.assessment.dto.PaymentTransactionWrapper;
import com.ejada.assessment.util.ActionApplyUtil;

import java.util.Map;
import java.util.concurrent.Callable;

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
public class PaymentRuleExecutorThread implements Callable {

    private Map<Integer, PaymentTransactionWrapper> map;

    private int nextRequiredRule = 1;
    private int totalRulesToBeExecuted;
    private PaymentTransactionDTO payment;

    public PaymentRuleExecutorThread(Map<Integer, PaymentTransactionWrapper> map, int ruleCount, PaymentTransactionDTO payment) {
        this.map = map;
        this.totalRulesToBeExecuted = ruleCount;
        this.payment = payment;
    }

    @Override
    public Object call() throws Exception {
        while (nextRequiredRule <= totalRulesToBeExecuted) {
            PaymentTransactionWrapper paymentRuleWrapper = map.get(nextRequiredRule);
            if (paymentRuleWrapper != null) {
                if (paymentRuleWrapper.isRuleMatched()) {
                    ActionApplyUtil.applyAction(paymentRuleWrapper.getRule().getAction(), payment);
                    payment.getAppliedRules().add(paymentRuleWrapper.getRule());
                }
                nextRequiredRule++;
            }
        }
        return payment;
    }
}
