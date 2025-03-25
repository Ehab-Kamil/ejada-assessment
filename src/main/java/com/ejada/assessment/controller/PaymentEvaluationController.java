package com.ejada.assessment.controller;

import com.ejada.assessment.dto.PaymentTransactionDTO;
import com.ejada.assessment.manager.impl.PaymentEnrichmentEvaluationManagerImpl;
import com.ejada.assessment.manager.impl.PaymentRoutingEvaluationManagerImpl;
import com.ejada.assessment.model.BusinessRule;
import com.ejada.assessment.model.BusinessRuleType;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * Title: BusinessRuleController.java
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
@RestController
@RequestMapping("/api/payment_transaction")
public class PaymentEvaluationController {

    @Autowired
    private PaymentEnrichmentEvaluationManagerImpl paymentEnrichmentEvaluationManager;

    @Autowired
    private PaymentRoutingEvaluationManagerImpl paymentRoutingEvaluationManager;

    /**
     * This Method will create a hashmap that will be passed to threads of Matching and the Thread of performing action Threads of matching will finalize its job by adding into this map the priority and the matched rule or priority and noAction Matching Thread will be created with Rule, Payment and HashMap Executing Thread will be created with HashMap (synchronize with ) Payment, and internal Variable created for the next required Action
     *
     * @param paymentTransaction
     * @return
     */
    @PostMapping("/evaluate")
    public ResponseEntity<PaymentTransactionDTO> evaluateTransaction(@Valid @RequestBody PaymentTransactionDTO paymentTransaction) {
        PaymentTransactionDTO result;
        if (paymentTransaction.getType().equals(BusinessRuleType.ENRICHMENT.toString())) {
            result = this.paymentEnrichmentEvaluationManager.evaluate(paymentTransaction);
        }
        else {
            result = this.paymentRoutingEvaluationManager.evaluate(paymentTransaction);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

}

