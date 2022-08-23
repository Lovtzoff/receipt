package ru.clevertec.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.clevertec.model.parent.BaseModel;

import java.util.Objects;

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
    private Double price;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getId().equals(product.getId()) &&
                getName().equals(product.getName()) &&
                getPrice().equals(product.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrice());
    }

    @Override
    public String toString() {
        return "id = " + super.getId() +
                ", name = " + name +
                ", price = $" + price;
    }
}
