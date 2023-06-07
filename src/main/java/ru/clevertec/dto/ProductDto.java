package ru.clevertec.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Класс транспортного слоя для передачи данных о товаре с полями <b>id</b>,
 * <b>name</b>, и <b>price</b>.
 *
 * @author Lovtsov Aliaksei
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
