package ru.clevertec.service;

import ru.clevertec.dto.ProductDto;

import java.util.List;

/**
 * Интерфейс с сервисом для товара.
 *
 * @author Ловцов Алексей
 */
public interface ProductService {

    /**
     * Найти товар по идентификатору.
     *
     * @param id идентификатор
     * @return товар product dto
     */
    ProductDto findOneById(Integer id);

    /**
     * Найти список всех товаров.
     *
     * @param size the size
     * @param page the page
     * @return список товаров dto
     */
    List<ProductDto> findAll(String size, String page);

    /**
     * Сохранить товар.
     *
     * @param productDto the product dto
     * @return the product dto
     */
    ProductDto save(ProductDto productDto);

    /**
     * Обновить товар.
     *
     * @param productDto the product dto
     * @param id         the id
     * @return the product dto
     */
    ProductDto update(ProductDto productDto, Integer id);

    /**
     * Удалить товар.
     *
     * @param id the id
     */
    void remove(Integer id);
}
