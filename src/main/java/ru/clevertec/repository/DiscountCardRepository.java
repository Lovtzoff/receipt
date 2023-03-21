package ru.clevertec.repository;

import ru.clevertec.model.DiscountCard;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс с методами для работы с таблицей DiscountCard в БД.
 *
 * @author Ловцов Алексей
 */
public interface DiscountCardRepository {

    /**
     * Найти карту по id.
     *
     * @param id the id
     * @return the optional
     */
    Optional<DiscountCard> findById(Integer id);

    /**
     * Найти все карты.
     *
     * @param size the size
     * @param page the page
     * @return the list
     */
    List<DiscountCard> findAll(Integer size, Integer page);

    /**
     * Добавить карту.
     *
     * @param discountCard the discount card
     * @return the discount card
     */
    DiscountCard add(DiscountCard discountCard);

    /**
     * Обновить карту.
     *
     * @param discountCard the discount card
     * @param id           the id
     * @return the optional
     */
    Optional<DiscountCard> update(DiscountCard discountCard, Integer id);

    /**
     * Удалить карту.
     *
     * @param id the id
     */
    void delete(Integer id);
}
