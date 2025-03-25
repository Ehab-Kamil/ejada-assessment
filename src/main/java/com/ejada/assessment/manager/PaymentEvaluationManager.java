package com.ejada.assessment.manager;

import com.ejada.assessment.dto.PaymentTransactionDTO;

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
 * @date 26/03/2025
 */
public interface PaymentEvaluationManager {

    public PaymentTransactionDTO evaluate(PaymentTransactionDTO payment);
}
