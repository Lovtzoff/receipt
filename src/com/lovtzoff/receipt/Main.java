package com.lovtzoff.receipt;

import com.lovtzoff.receipt.data.impl.DataReaderImpl;
import com.lovtzoff.receipt.exception.ParameterNotFoundException;
import com.lovtzoff.receipt.model.Receipt;
import com.lovtzoff.receipt.service.ReceiptService;
import com.lovtzoff.receipt.service.impl.ReceiptServiceImpl;
import com.lovtzoff.receipt.validation.ParameterValidator;
import com.lovtzoff.receipt.validation.RegexValidator;

/**
 * Основной класс приложения.
 */
public class Main {

    /**
     * Точка запуска приложения.
     *
     * @param args массив входных параметров
     */
    public static void main(String[] args) {

        RegexValidator.checkData(new DataReaderImpl().getRegexData());

        try {
            ParameterValidator.isValid(args);
            ReceiptService receiptService = new ReceiptServiceImpl();
            Receipt receipt = receiptService.generateReceipt(args);
            receiptService.printReceipt(receipt);
        } catch (ParameterNotFoundException ex) {
            System.out.println("Message: " + ex.getMessage());
        }
    }
}
