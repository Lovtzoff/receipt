package com.lovtzoff.receipt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Класс модели магазинного чека с полями:
 * <b>header</b>,
 * <b>cashier</b>,
 * <b>printDate</b>,
 * <b>printTime</b>,
 * <b>productsList</b>,
 * <b>totalNoDiscount</b>,
 * <b>discount</b>,
 * <b>totalWithDiscount</b>.
 *
 * @author Ловцов Алексей
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Receipt {

    /**
     * Заголовок.
     */
    private Header header;
    /**
     * Кассир.
     */
    private Cashier cashier;
    /**
     * Дата печати.
     */
    private String printDate;
    /**
     * Время печати.
     */
    private String printTime;
    /**
     * Список продуктов.
     */
    private List<Products> productsList;
    /**
     * Конечная цена без скидки.
     */
    private double totalNoDiscount;
    /**
     * Скидка.
     */
    private double discount;
    /**
     * Конечная цена со скидкой.
     */
    private double totalWithDiscount;

    @Override
    public String toString() {
        return header + "\n" +
                cashier + "\n" +
                "Date: " + printDate +
                ", Time: " + printTime + "\n" +
                productsList + "\n" +
                "Total no discount: $" + totalNoDiscount + "\n" +
                "Discount: $" + discount + "\n" +
                "Total with discount: $" + totalWithDiscount;
    }
}
