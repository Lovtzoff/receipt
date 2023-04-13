package ru.clevertec;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.clevertec.config.ApplicationConfiguration;
import ru.clevertec.exception.ParameterNotFoundException;
import ru.clevertec.model.Receipt;
import ru.clevertec.service.ReceiptService;
import ru.clevertec.validation.ParameterValidator;

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

        try {
            ParameterValidator.isValid(args);
            ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
            ReceiptService receiptService = context.getBean(ReceiptService.class);
            Receipt receipt = receiptService.generateReceipt(args);
            receiptService.printReceipt(receipt);
        } catch (ParameterNotFoundException ex) {
            System.out.println("Message: " + ex.getMessage());
        }
    }
}
