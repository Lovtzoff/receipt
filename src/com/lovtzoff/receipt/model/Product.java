package com.lovtzoff.receipt.model;

import com.lovtzoff.receipt.model.parent.BaseModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Класс товара с полем <b>id</b>, унаследованным от абстрактного класса BaseModel,
 * и полями <b>name</b>, и <b>price</b>.
 *
 * @author Ловцов Алексей
 * @see BaseModel
 */
@NoArgsConstructor
@Getter
@Setter
public class Product extends BaseModel {

    /**
     * Название.
     */
    private String name;
    /**
     * Цена за единицу товара.
     */
    private double price;

    /**
     * Конструктор нового товара.
     *
     * @param id    идентификатор
     * @param name  название
     * @param price цена
     * @see Product#Product(Integer, String, double)
     */
    public Product(Integer id, String name, double price) {
        super(id);
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "name = " + name +
                ", price = $" + price;
    }
}
