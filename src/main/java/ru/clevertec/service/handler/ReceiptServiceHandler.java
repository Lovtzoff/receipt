package ru.clevertec.service.handler;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import ru.clevertec.exception.ParameterNotFoundException;
import ru.clevertec.service.ReceiptService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReceiptServiceHandler implements InvocationHandler {

    private final ReceiptService receiptService;

    private static final String EMPTY_STRING = "";

    public ReceiptServiceHandler(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            Gson parserGson = new Gson();
            Object invoke = method.invoke(receiptService, args);

            String arguments = (args != null) ? parserGson.toJson(args) : EMPTY_STRING;
            String result = (invoke != null) ? parserGson.toJson(invoke) : EMPTY_STRING;

            log.info("{} args={}", method.getName(), arguments);
            log.info("{} result={}", method.getName(), result);

            return invoke;
        } catch (InvocationTargetException invocationTargetException) {
            throw invocationTargetException.getCause();
        }
    }
}
