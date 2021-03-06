package ru.clevertec.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@Getter
@Setter
public class DiscountCard extends BaseModel {

    /**
     * Скидка.
     */
    private Integer discount;

    /**
     * Конструктор новой скидочной карты.
     *
     * @param id       идентификатор
     * @param discount скидка
     * @see DiscountCard#DiscountCard(Integer, int)
     */
    public DiscountCard(Integer id, int discount) {
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
