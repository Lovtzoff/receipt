package ru.clevertec.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Класс транспортного слоя для передачи данных о дисконтной карте с полями <b>id</b>
 * и <b>discount</b>.
 *
 * @author Lovtsov Aliaksei
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
