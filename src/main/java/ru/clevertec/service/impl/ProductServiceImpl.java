package ru.clevertec.service.impl;

import ru.clevertec.dao.ProductDao;
import ru.clevertec.exception.ParameterNotFoundException;
import ru.clevertec.model.Product;
import ru.clevertec.service.ProductService;

import java.util.List;
import java.util.Optional;

/**
 * Реализация интерфейса ProductService.
 *
 * @author Ловцов Алексей
 * @see ProductService
 */
public class ProductServiceImpl implements ProductService {

    /**
     * Получение данных из базы.
     */
    private final ProductDao productDao;

    /**
     * Конструктор нового сервиса для товара, в который передаются данные из базы.
     *
     * @param productDao считыватель данных
     */
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    //------------------------------------------------------------------------------------------------

    @Override
    public Product findOneById(Integer id) {
        Optional<Product> optionalProduct = productDao.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        throw new ParameterNotFoundException("Присутствуют товары, отсутствующие в каталоге!");
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = productDao.findAll();
        if (!products.isEmpty()) {
            return products;
        }
        throw new ParameterNotFoundException("Ошибка чтения каталога товаров! База товаров пуста!");
    }
}
