package ru.clevertec.dto;

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
public class ProductDto {

    /**
     * Идентификатор.
     */
    Integer id;
    /**
     * Название.
     */
    String name;
    /**
     * Цена за единицу товара.
     */
    Double price;
}
