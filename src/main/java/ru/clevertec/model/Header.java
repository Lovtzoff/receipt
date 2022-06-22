package ru.clevertec.model;

import lombok.Getter;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Header header = (Header) o;
        return getShopName().equals(header.getShopName()) &&
                getCity().equals(header.getCity()) &&
                getStreet().equals(header.getStreet()) &&
                getTel().equals(header.getTel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getShopName(), getCity(), getStreet(), getTel());
    }

    @Override
    public String toString() {
        return shopName + "\n" +
                City + "\n" +
                Street + "\n" +
                "Tel: " + tel;
    }
}
