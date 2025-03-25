package com.ejada.assessment.model;

/**
 * <p>
 * Title: BussinessRuleType.java
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
public enum BusinessRuleType {

    ENRICHMENT(0), ROUTING(1);

    private int value;

    BusinessRuleType(int value) {
        this.value = value;
    }
}
