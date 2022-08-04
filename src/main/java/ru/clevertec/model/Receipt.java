package ru.clevertec.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

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
    private Double totalNoDiscount;
    /**
     * Скидка.
     */
    private Double discount;
    /**
     * Конечная цена со скидкой.
     */
    private Double totalWithDiscount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return getHeader().equals(receipt.getHeader()) &&
                getCashier().equals(receipt.getCashier()) &&
                getPrintDate().equals(receipt.getPrintDate()) &&
                getProductsList().equals(receipt.getProductsList()) &&
                getTotalNoDiscount().equals(receipt.getTotalNoDiscount()) &&
                getDiscount().equals(receipt.getDiscount()) &&
                getTotalWithDiscount().equals(receipt.getTotalWithDiscount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getHeader(),
                getCashier(),
                getPrintDate(),
                getPrintTime(),
                getProductsList(),
                getTotalNoDiscount(),
                getDiscount(),
                getTotalWithDiscount()
        );
    }

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
