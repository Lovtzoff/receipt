package ru.clevertec.model;

import lombok.Getter;

/**
 * Класс заголовка чека.
 *
 * @author Ловцов Алексей
 */
@Getter
public class Header {

    /**
     * Название магазина.
     */
    private final String shopName = "StroyMarket";
    /**
     * Город.
     */
    private final String City = "Kupetsk";
    /**
     * Улица.
     */
    private final String Street = "Bazarnaya 127";
    /**
     * Телевон.
     */
    private final String tel = "123-456-7890";

    @Override
    public String toString() {
        return shopName + "\n" +
                City + "\n" +
                Street + "\n" +
                "Tel: " + tel;
    }
}
