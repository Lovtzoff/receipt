package ru.clevertec.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

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
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(exclude = "printTime")
public class Receipt {

    /**
     * Заголовок.
     */
    Header header;
    /**
     * Кассир.
     */
    Cashier cashier;
    /**
     * Дата печати.
     */
    String printDate;
    /**
     * Время печати.
     */
    String printTime;
    /**
     * Список продуктов.
     */
    List<Products> productsList;
    /**
     * Конечная цена без скидки.
     */
    Double totalNoDiscount;
    /**
     * Скидка.
     */
    Double discount;
    /**
     * Конечная цена со скидкой.
     */
    Double totalWithDiscount;
}
