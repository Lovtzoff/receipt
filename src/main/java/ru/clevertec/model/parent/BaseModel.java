package ru.clevertec.model.parent;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Абстрактный класс BaseModel с полем <b>id</b>.
 *
 * @author Ловцов Алексей
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseModel {

    /**
     * Идентификатор.
     */
    Integer id;
}
