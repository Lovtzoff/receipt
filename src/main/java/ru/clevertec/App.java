package ru.clevertec;

import ru.clevertec.data.impl.DataReaderImpl;
import ru.clevertec.exception.ParameterNotFoundException;
import ru.clevertec.model.Receipt;
import ru.clevertec.service.ReceiptService;
import ru.clevertec.service.proxy.ReceiptServiceProxy;
import ru.clevertec.validation.ParameterValidator;
import ru.clevertec.validation.RegexValidator;

/**
 * Основной класс приложения.
 */
public class App {

    /**
     * Точка запуска приложения.
     *
     * @param args массив входных параметров
     */
    public static void main(String[] args) {

        RegexValidator.checkData(new DataReaderImpl().getRegexData());

        try {
            ParameterValidator.isValid(args);
            ReceiptService receiptService = new ReceiptServiceProxy();
            Receipt receipt = receiptService.generateReceipt(args);
            receiptService.printReceipt(receipt);
        } catch (ParameterNotFoundException ex) {
            System.out.println("Message: " + ex.getMessage());
        }
    }
}
