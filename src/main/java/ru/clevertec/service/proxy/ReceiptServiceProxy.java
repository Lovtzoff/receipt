package ru.clevertec.service.proxy;

import org.springframework.stereotype.Service;
import ru.clevertec.model.Receipt;
import ru.clevertec.service.ReceiptService;
import ru.clevertec.service.handler.ReceiptServiceHandler;
import ru.clevertec.service.impl.ReceiptServiceImpl;

import java.lang.reflect.Proxy;

@Service("receiptServiceProxy")
public class ReceiptServiceProxy implements ReceiptService {

    private static ReceiptService receiptService;

    static {
        receiptService = new ReceiptServiceImpl();
        ClassLoader receiptServiceClassLoader = receiptService.getClass().getClassLoader();
        Class<?>[] receiptServiceInterfaces = receiptService.getClass().getInterfaces();
        receiptService = (ReceiptService) Proxy.newProxyInstance(
                receiptServiceClassLoader,
                receiptServiceInterfaces,
                new ReceiptServiceHandler(receiptService)
        );
    }

    @Override
    public Receipt generateReceipt(String[] args) {
        return receiptService.generateReceipt(args);
    }

    @Override
    public void printReceipt(Receipt receipt) {
        receiptService.printReceipt(receipt);
    }
}
