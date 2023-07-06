package ru.clevertec.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс сообщения об ошибке.
 *
 * @author Lovtsov Aliaksei
 */
@Getter
@Setter
@AllArgsConstructor
public class ErrorMessage {

    /**
     * Сообщение.
     */
    private String message;
}
