package com.ejada.assessment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * <p>
 * Title: TaskDto.java
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
@Data
@AllArgsConstructor
public class PaymentTransactionWrapper {
    private PaymentTransactionDTO paymentTransactionDTO;
    private boolean ruleMatched;
    private BusinessruleDTO rule;
}
