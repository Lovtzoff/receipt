package ru.clevertec.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.clevertec.model.parent.BaseModel;

import javax.persistence.Entity;

/**
 * Класс товара с полем <b>id</b>, унаследованным от абстрактного класса BaseModel,
 * и полями <b>name</b>, и <b>price</b>.
 *
 * @author Lovtsov Aliaksei
 * @see BaseModel
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@Entity
public class Product extends BaseModel {

    /**
     * Название.
     */
    String productName;
    /**
     * Цена за единицу товара.
     */
    Double price;

    /**
     * Конструктор нового товара.
     *
     * @param id    идентификатор
     * @param name  название
     * @param price цена
     * @see Product#Product(Integer, String, Double)
     */
    @Builder
    public Product(Integer id, String name, Double price) {
        super(id);
        this.productName = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "id = " + super.getId() +
                ", name = " + productName +
                ", price = $" + price;
    }
}
