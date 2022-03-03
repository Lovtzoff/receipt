package com.lovtzoff.receipt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Класс товара в чеке с полями <b>count</b>, <b>product</b> и <b>totalPrice</b>.
 *
 * @author Ловцов Алексей
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Products {

    /**
     * Количество товара в чеке.
     */
    private int count;
    /**
     * Товар.
     */
    private Product product;
    /**
     * Конечная цена товара, по количеству в чеке.
     */
    private double totalPrice;

    @Override
    public String toString() {
        return "count = " + count +
                ", " + product +
                ", totalPrice = $" + totalPrice;
    }
}
