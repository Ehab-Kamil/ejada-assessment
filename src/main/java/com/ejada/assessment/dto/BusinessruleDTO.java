package com.ejada.assessment.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

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
public class BusinessruleDTO extends AbstractDTO {

    private Long id;
    private String name;
    private Integer priority;

    @NotNull(message = "Action cannot be null")
    @Pattern(
        regexp = "^[a-zA-Z0-9_]+::[a-zA-Z=!<>]+::[a-zA-Z0-9_]+$",
        message = "Action must be in the format 'field::operator::value'"
    )
    private String action;

    @NotNull(message = "Condition cannot be null")
    @Pattern(
        regexp = "^[a-zA-Z0-9_]+::[a-zA-Z=!<>]+::[a-zA-Z0-9_]+$",
        message = "Condition must be in the format 'field::operator::value'"
    )
    private String condition;

    private String ruleType;

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
