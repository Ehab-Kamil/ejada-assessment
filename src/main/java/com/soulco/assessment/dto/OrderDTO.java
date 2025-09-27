package com.soulco.assessment.dto;

import jakarta.validation.constraints.Pattern;

/**
 * <p>
 * Title: OrderDTO.java
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
public class OrderDTO extends OrderSummaryDTO{

    @Pattern(regexp = "^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/([0-9]{4})$")
    private String date;


}
