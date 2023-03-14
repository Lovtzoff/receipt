package ru.clevertec.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import ru.clevertec.model.parent.BaseModel;

/**
 * Класс модели скидочной карты с полем <b>id</b>, унаследованным от абстрактного класса BaseModel,
 * и полем <b>discount</b>.
 *
 * @author Ловцов Алексей
 * @see BaseModel
 */
@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
public class DiscountCard extends BaseModel {

    /**
     * Скидка.
     */
    Integer discount;

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
    public String toString() {
        return "Card № " + super.getId() +
                ", discount = " + discount +
                "%";
    }
}
