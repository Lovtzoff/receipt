package ru.clevertec.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.clevertec.model.parent.BaseModel;

import java.util.Objects;

/**
 * Класс модели скидочной карты с полем <b>id</b>, унаследованным от абстрактного класса BaseModel,
 * и полем <b>discount</b>.
 *
 * @author Ловцов Алексей
 * @see BaseModel
 */
@AllArgsConstructor
@Getter
@Setter
public class DiscountCard extends BaseModel {

    /**
     * Скидка.
     */
    private Integer discount;

    /**
     * Конструктор пустой скидочной карты.
     */
    public DiscountCard() {
        super(0);
        this.discount = 0;
    }

    /**
     * Конструктор новой скидочной карты.
     *
     * @param id       идентификатор
     * @param discount скидка
     * @see DiscountCard#DiscountCard(Integer, Integer)
     */
    public DiscountCard(Integer id, Integer discount) {
        super(id);
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountCard discountCard = (DiscountCard) o;
        return getId().equals(discountCard.getId()) &&
                getDiscount().equals(discountCard.getDiscount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDiscount());
    }

    @Override
    public String toString() {
        return "Card № " + super.getId() +
                ", discount = " + discount +
                "%";
    }
}
