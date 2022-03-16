package ru.clevertec.service;

import ru.clevertec.model.DiscountCard;

import java.util.List;

/**
 * Интерфейс с сервисом для скидочной карты.
 *
 * @author Ловцов Алексей
 */
public interface DiscountCardService {

    /**
     * Найти скидочную карту по идентификатору.
     *
     * @param id идентификатор
     * @return скидочная карта
     */
    DiscountCard findOneById(Integer id);

    /**
     * Найти список всех скидочных карт.
     *
     * @return список карт
     */
    List<DiscountCard> findAll();
}
