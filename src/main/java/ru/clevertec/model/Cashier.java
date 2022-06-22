package ru.clevertec.model;

import ru.clevertec.model.parent.BaseModel;

import java.util.Objects;

/**
 * Класс модели кассира с полем <b>id</b>, унаследованным от абстрактного класса BaseModel.
 *
 * @author Ловцов Алексей
 * @see BaseModel
 */
public class Cashier extends BaseModel {

    /**
     * Конструктор нового кассира.
     *
     * @param id идентификатор
     * @see Cashier#Cashier(Integer)
     */
    public Cashier(Integer id) {
        super(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cashier cashier = (Cashier) o;
        return getId().equals(cashier.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Cashier №" + super.getId();
    }
}
