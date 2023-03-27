package ru.clevertec.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Класс товара в чеке с полями <b>count</b>, <b>product</b> и <b>totalPrice</b>.
 *
 * @author Ловцов Алексей
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Products {

    /**
     * Количество товара в чеке.
     */
    Integer count;
    /**
     * Товар.
     */
    Product product;
    /**
     * Конечная цена товара, по количеству в чеке.
     */
    Double totalPrice;
}
