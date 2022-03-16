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
     * @return товар
     */
    Product findOneById(Integer id);

    /**
     * Найти список всех товаров.
     *
     * @return список товаров
     */
    List<Product> findAll();
}
