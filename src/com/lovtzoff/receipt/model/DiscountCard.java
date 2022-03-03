package com.lovtzoff.receipt.model;

import com.lovtzoff.receipt.model.parent.BaseModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private int discount;

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
    public String toString() {
        return "Card № " + super.getId() +
                ", discount = " + discount +
                "%";
    }
}
