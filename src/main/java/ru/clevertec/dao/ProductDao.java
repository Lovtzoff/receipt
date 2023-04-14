package ru.clevertec.dao;

import ru.clevertec.model.Product;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс с методами для работы с таблицей Product в БД.
 *
 * @author Ловцов Алексей
 */
public interface ProductDao {

    /**
     * Найти товар по id.
     *
     * @param id the id
     * @return the optional
     */
    Optional<Product> findById(Integer id);

    /**
     * Найти все товары.
     *
     * @param size the size
     * @param page the page
     * @return the list
     */
    List<Product> findAll(Integer size, Integer page);

    /**
     * Добавить товар.
     *
     * @param product the product
     * @return the product
     */
    Product add(Product product);

    /**
     * Обновить товар.
     *
     * @param product the product
     * @param id      the id
     * @return the optional
     */
    Optional<Product> update(Product product, Integer id);

    /**
     * Удалить товар.
     *
     * @param id the id
     */
    void delete(Integer id);
}
