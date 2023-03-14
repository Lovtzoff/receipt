package ru.clevertec.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Класс модели скидочной карты с полем <b>id</b>, унаследованным от абстрактного класса BaseModel,
 * и полем <b>discount</b>.
 *
 * @author Ловцов Алексей
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DiscountCardDto {

    /**
     * Идентификатор.
     */
    Integer id;
    /**
     * Скидка.
     */
    Integer discount;
}
