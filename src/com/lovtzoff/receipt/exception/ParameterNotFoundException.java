package com.lovtzoff.receipt.exception;

/**
 * Сигналы о том, что произошло какое-то исключение, связанное с входными данными.
 *
 * @author Ловцов Алексей
 */
public class ParameterNotFoundException extends RuntimeException {

    /**
     * Создает новое исключение "Parameter not found".
     */
    public ParameterNotFoundException() {
        super("Параметры не заданы.");
    }

    /**
     * Создает новое исключение «Parameter not found», с заданным сообщением.
     *
     * @param message сообщение
     */
    public ParameterNotFoundException(String message) {
        super(message);
    }
}
