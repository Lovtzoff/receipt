package ru.clevertec.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

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
    private Integer count;
    /**
     * Товар.
     */
    private Product product;
    /**
     * Конечная цена товара, по количеству в чеке.
     */
    private Double totalPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return getCount().equals(products.getCount()) &&
                getProduct().equals(products.getProduct()) &&
                getTotalPrice().equals(products.getTotalPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCount(), getProduct(), getTotalPrice());
    }

    @Override
    public String toString() {
        return "count = " + count +
                ", " + product +
                ", totalPrice = $" + totalPrice;
    }
}
