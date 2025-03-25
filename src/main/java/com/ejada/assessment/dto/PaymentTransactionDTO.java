package com.ejada.assessment.dto;

import lombok.Data;

import java.util.ArrayList;
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
public class PaymentTransactionDTO extends AbstractDTO {

    private Long amount;
    private String direction;
    private String type;
    private List<BusinessruleDTO> appliedRules = new ArrayList<>();
}
