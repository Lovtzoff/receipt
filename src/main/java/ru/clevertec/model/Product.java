package ru.clevertec.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.clevertec.model.parent.BaseModel;

/**
 * Класс товара с полем <b>id</b>, унаследованным от абстрактного класса BaseModel,
 * и полями <b>name</b>, и <b>price</b>.
 *
 * @author Ловцов Алексей
 * @see BaseModel
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
public class Product extends BaseModel {

    /**
     * Название.
     */
    String name;
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
    public Product(Integer id, String name, Double price) {
        super(id);
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "id = " + super.getId() +
                ", name = " + name +
                ", price = $" + price;
    }
}
