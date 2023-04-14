package ru.clevertec.service;

import ru.clevertec.model.Product;

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
     * @return товар product
     */
    Product findOneById(Integer id);

    /**
     * Найти список всех товаров.
     *
     * @param size the size
     * @param page the page
     * @return список товаров
     */
    List<Product> findAll(String size, String page);

    /**
     * Сохранить товар.
     *
     * @param product the product
     * @return the product
     */
    Product save(Product product);

    /**
     * Обновить товар.
     *
     * @param product the product
     * @param id      the id
     * @return the product
     */
    Product update(Product product, Integer id);

    /**
     * Удалить товар.
     *
     * @param id the id
     */
    void remove(Integer id);
}
