package ru.clevertec.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.clevertec.model.Receipt;
import ru.clevertec.service.impl.ReceiptServiceImpl;
import ru.clevertec.util.ReceiptUtils;

import java.util.stream.Stream;

import static ru.clevertec.constants.Constants.STRING_SEPARATOR;

class ReceiptServiceTest {

    static Receipt receipt;
    ReceiptService receiptService = new ReceiptServiceImpl();
    static String[] sourceArray = new String[]{"3-1", "2-5", "5-1", "card-1230"};

    @BeforeAll
    static void generateTestReceipt() {
        receipt = ReceiptUtils.createReceipt(sourceArray);
    }

    @AfterAll
    static void deleteTestReceipt() {
        receipt = null;
    }

    @Test
    void generateReceiptTest() {
        Assertions.assertEquals(receipt, receiptService.generateReceipt(sourceArray));
    }

    static Stream<String> generateInputStrings() {
        return Stream.of(
                "6-1 15-7 24-3 2-2 card-1207",
                "16-10 8-20 card-1214",
                "27-14 4-7 11-9 card-1223"
        );
    }

    @ParameterizedTest
    @MethodSource("generateInputStrings")
    void generateReceiptParameterizedTest(String inputStrings) {
        Assertions.assertEquals(
                ReceiptUtils.createReceipt(inputStrings.split(STRING_SEPARATOR)),
                receiptService.generateReceipt(inputStrings.split(STRING_SEPARATOR))
        );
    }
}