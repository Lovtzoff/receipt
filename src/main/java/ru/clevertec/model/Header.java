package ru.clevertec.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Класс заголовка чека.
 *
 * @author Ловцов Алексей
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Header {

    /**
     * Название магазина.
     */
    final String shopName = "StroyMarket";
    /**
     * Город.
     */
    final String City = "Kupetsk";
    /**
     * Улица.
     */
    final String Street = "Bazarnaya 127";
    /**
     * Телефон.
     */
    final String tel = "123-456-7890";

    @Override
    public String toString() {
        return shopName + "\n" +
                City + "\n" +
                Street + "\n" +
                "Tel: " + tel;
    }
}
