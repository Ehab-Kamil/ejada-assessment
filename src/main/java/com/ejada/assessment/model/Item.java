package com.ejada.assessment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>
 * Title: Order.java
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
 * @date 24/09/2025
 */
@Data
@Entity
public class Item extends AbstractEntity {


    private BigDecimal unitPrice;
    private BigDecimal nrUnits;

    @ManyToOne
    private Product product;
}
