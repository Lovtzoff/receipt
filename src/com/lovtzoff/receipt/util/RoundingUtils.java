package com.lovtzoff.receipt.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.lovtzoff.receipt.constants.Constants.SCALE_DEFAULT;

/**
 * Класс, содержащий статические методы для округления чисел.
 *
 * @author Ловцов Алексей
 */
public class RoundingUtils {

    /**
     * Округлить double.
     *
     * @param source входное число double
     * @return the double
     */
    public static double round(Double source) {
        BigDecimal result = new BigDecimal(source).setScale(SCALE_DEFAULT, RoundingMode.HALF_EVEN);
        return result.doubleValue();
    }
}
