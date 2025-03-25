package com.ejada.assessment.util;

import com.ejada.assessment.dto.PaymentTransactionDTO;

import java.lang.reflect.Method;

import static com.ejada.assessment.util.Operators.DECREMENT_VALUE;
import static com.ejada.assessment.util.Operators.EQUALS;
import static com.ejada.assessment.util.Operators.GREATER_THAN;
import static com.ejada.assessment.util.Operators.INCREMENT_VALUE;
import static com.ejada.assessment.util.Operators.LESS_THAN;
import static com.ejada.assessment.util.Operators.SET_VALUE;

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

public class ActionApplyUtil {

    public static void applyAction(String action, PaymentTransactionDTO payment) {
        String[] parts = action.split("::");

        String field = parts[0];   // "direction"
        String operator = parts[1]; // "set"
        String value = parts[2];    // "somewhere"
        Object fieldValue;
        try {
            if (operator.equals(SET_VALUE)) {
                ActionApplyUtil.setValueOfAttributeToObject(payment, field, value);
            }

        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void setValueOfAttributeToObject(Object obj, String attribute, Object value) throws Exception {

        // Use reflection to set the field value dynamically
        Method setter = obj.getClass().getMethod("set" + capitalize(attribute), String.class);
        setter.invoke(obj, value);
    }

    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
