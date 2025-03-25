package com.ejada.assessment.util;

import com.ejada.assessment.dto.PaymentTransactionDTO;

import java.lang.reflect.Method;

import static com.ejada.assessment.util.Operators.EQUALS;
import static com.ejada.assessment.util.Operators.GREATER_THAN;
import static com.ejada.assessment.util.Operators.LESS_THAN;

/**
 * <p>
 * Title: ConditionEvaluator.java
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

public class ConditionEvaluatorUtil {

    public static boolean applyCondition(String condition, PaymentTransactionDTO payment) {
        String[] parts = condition.split("::");

        String field = parts[0];   // "amount"
        String operator = parts[1]; // "eq"
        String expectedValue = parts[2];    // "5"
        Object fieldValue;
        try {
            fieldValue = ConditionEvaluatorUtil.getValueOfAttributeFromObject(payment, field);
        }
        catch (Exception e) {
            // unable to getValue
            throw new RuntimeException(e);
        }

        // Apply the condition
        boolean result = false;
        if (operator.equals(EQUALS)) {
            result = (Long)fieldValue == Long.parseLong(expectedValue);
        }
        else if (operator.equals(GREATER_THAN)) { // Greater than
            result = (Long)fieldValue > Long.parseLong(expectedValue);
        }
        else if (operator.equals(LESS_THAN)) { // Less than
            result = (Long)fieldValue < Long.parseLong(expectedValue);
        }

        return result;
    }

    public static Object getValueOfAttributeFromObject(Object obj, String attribute) throws Exception {

        String condition = "amount::eq::5";
        String[] parts = condition.split("::");

        String field = parts[0];   // "amount"
        String operator = parts[1]; // "eq"
        String value = parts[2];    // "5"

        // Convert value to appropriate type (assuming integer for this example)
        int expectedValue = Integer.parseInt(value);

        // Use reflection to get the field value dynamically
        Method getter = obj.getClass().getMethod("get" + capitalize(attribute));
        Object fieldValue = getter.invoke(obj);

        return fieldValue;
    }

    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
