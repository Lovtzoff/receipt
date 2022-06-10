package ru.clevertec.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.clevertec.exception.ParameterNotFoundException;

import java.util.stream.Stream;

import static ru.clevertec.constants.Constants.STRING_SEPARATOR;

class ParameterValidatorTest {

    static String[] sourceArray = new String[]{};

    @Test
    void isValidTest() {
        Assertions.assertThrows(
                ParameterNotFoundException.class,
                () -> ParameterValidator.isValid(sourceArray)
        );
    }

    static Stream<String> generateInputStrings() {
        return Stream.of(
                "-1 15-7 24-3 2-2 card-1207",
                "16- 20",
                "- 4- -9 card-1223"
        );
    }

    @ParameterizedTest
    @MethodSource("generateInputStrings")
    void isValidParameterizedTest(String inputStrings) {
        Assertions.assertThrows(
                ParameterNotFoundException.class,
                () -> ParameterValidator.isValid(inputStrings.split(STRING_SEPARATOR))
        );
    }
}