package com.ejada.assessment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

/**
 * <p>
 * Title: BussinessRule.java
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
@Entity
@Data
public class BusinessRule extends AbstractEntity {

    private String name;

    // this condition should match on one field of the payment transaction
    private String condition;

    // The action will be applied on the entity but not right now, it will be applied according to priority
    private String action;

    private int priority;

    @Enumerated(EnumType.ORDINAL)
    private BusinessRuleType ruleType;
}
