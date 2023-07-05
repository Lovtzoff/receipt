package ru.clevertec.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.clevertec.model.Receipt;
import ru.clevertec.util.TestDataUtils;

import java.util.stream.Stream;

import static ru.clevertec.constants.Constants.STRING_SEPARATOR;

/**
 * Тесты сервиса для чека.
 */
@SpringBootTest
class ReceiptServiceTest {

    /**
     * Сервис чека.
     */
    @Autowired
    private ReceiptService receiptService;
    /**
     * Чек.
     */
    static Receipt receipt;
    /**
     * Исходный массив.
     */
    static String[] sourceArray = new String[]{"3-1", "2-5", "5-1", "card-30"};

    /**
     * Генерация чека для сравнения.
     */
    @BeforeAll
    static void generateTestReceipt() {
        receipt = TestDataUtils.createReceipt(sourceArray);
    }

    /**
     * Удаление тестового чека.
     */
    @AfterAll
    static void deleteTestReceipt() {
        receipt = null;
    }

    /**
     * Тест генерации чека.
     */
    @Test
    void generateReceiptTest() {
        Assertions.assertEquals(receipt, receiptService.generateReceipt(sourceArray));
    }

    /**
     * Генерация входных строк.
     *
     * @return the stream
     */
    static Stream<String> generateInputStrings() {
        return Stream.of(
                "6-1 15-7 24-3 2-2 card-7",
                "16-10 8-20 card-14",
                "27-14 4-7 11-9 card-23"
        );
    }

    /**
     * Параметризованный тест генерации чека.
     *
     * @param inputStrings the input strings
     */
    @ParameterizedTest
    @MethodSource("generateInputStrings")
    void generateReceiptParameterizedTest(String inputStrings) {
        Assertions.assertEquals(
                TestDataUtils.createReceipt(inputStrings.split(STRING_SEPARATOR)),
                receiptService.generateReceipt(inputStrings.split(STRING_SEPARATOR))
        );
    }
}