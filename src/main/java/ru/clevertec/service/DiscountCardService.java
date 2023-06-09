package ru.clevertec.service;

import ru.clevertec.dto.DiscountCardDto;

import java.util.List;

/**
 * Интерфейс с сервисом для дисконтной карты.
 *
 * @author Ловцов Алексей
 */
public interface DiscountCardService {

    /**
     * Найти дисконтную карту по идентификатору.
     *
     * @param id идентификатор
     * @return дисконтная карта dto
     */
    DiscountCardDto findOneById(Integer id);

    /**
     * Найти список всех дисконтных карт.
     *
     * @param size the size
     * @param page the page
     * @return список карт
     */
    List<DiscountCardDto> findAll(String size, String page);

    /**
     * Сохранить карту.
     *
     * @param discountCardDto the discount card dto
     * @return the discount card dto
     */
    DiscountCardDto save(DiscountCardDto discountCardDto);

    /**
     * Обновить карту.
     *
     * @param discountCardDto the discount card dto
     * @param id              the id
     * @return the discount card dto
     */
    DiscountCardDto update(DiscountCardDto discountCardDto, Integer id);

    /**
     * Удалить карту.
     *
     * @param id the id
     */
    void remove(Integer id);
}
