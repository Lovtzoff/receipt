package com.lovtzoff.receipt.validation;

import com.lovtzoff.receipt.exception.ParameterNotFoundException;
import com.lovtzoff.receipt.util.ParameterUtils;
import com.lovtzoff.receipt.util.StringUtils;

import static com.lovtzoff.receipt.constants.Constants.ARG_SEPARATOR;

/**
 * Класс, содержащий статические методы для проверки входных параметров.
 *
 * @author Ловцов Алексей
 */
public class ParameterValidator {

    /**
     * Является действительным.
     *
     * @param args массив входных параметров
     */
    public static void isValid(String[] args) {
        if (ParameterUtils.checkForNull(args)) {
            throw new ParameterNotFoundException();
        }
        for (String arg : args) {
            String[] array = arg.split(ARG_SEPARATOR, -1);
            for (String s : array) {
                if (StringUtils.isEmpty(s)) {
                    throw new ParameterNotFoundException("Присутствуют пустые параметры!");
                }
            }
        }
    }
}
