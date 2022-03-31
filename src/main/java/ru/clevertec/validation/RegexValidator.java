package ru.clevertec.validation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ru.clevertec.constants.Constants.*;

/**
 * Класс, содержащий статические методы для проверки regex данных.
 */
public class RegexValidator {

    /**
     * Проверить данные. Результат проверки сохраняется в текстовые файлы.
     *
     * @param sourceList входной лист строк
     */
    public static void checkData(List<String> sourceList) {
        String regex = "(^[1-9]\\d?|100);" +
                "(([А-ЯЁ][а-яё]{2,29})|([A-Z][a-z]{2,29}));" +
                "([1-9]\\d?\\.\\d{2}|100\\.00);" +
                "([1-9]|[1]\\d|20)$";
        List<String> invalidList = new ArrayList<>();
        List<String> validList = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        for (String str : sourceList) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                validList.add(str);
            } else {
                invalidList.add(str);
            }
        }
        try {
            Files.write(Paths.get(INVALID_DATA_LIST), invalidList, StandardOpenOption.CREATE);
            Files.write(Paths.get(VALID_DATA_LIST), validList, StandardOpenOption.CREATE);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
