package ru.clevertec.validation;

import ru.clevertec.constants.Constants;
import ru.clevertec.exception.ParameterNotFoundException;
import ru.clevertec.util.ParameterUtils;
import ru.clevertec.util.StringUtils;

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
            String[] array = arg.split(Constants.ARG_SEPARATOR, -1);
            for (String s : array) {
                if (StringUtils.isEmpty(s)) {
                    throw new ParameterNotFoundException("Присутствуют пустые параметры!");
                }
            }
        }
    }
}
