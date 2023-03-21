package ru.clevertec.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.clevertec.model.parent.BaseModel;

/**
 * Класс транспортного слоя для передачи данных о товаре с полями <b>id</b>,
 * <b>name</b>, и <b>price</b>.
 *
 * @author Ловцов Алексей
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
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
