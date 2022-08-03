package ru.clevertec.dao;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.clevertec.dao.impl.ProductDaoImpl;
import ru.clevertec.model.Product;
import ru.clevertec.util.ProductUtils;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ProductDaoTest {

    private final ProductDao productDao = new ProductDaoImpl();
    static List<Product> productList;

    @BeforeAll
    static void generateProducts() {
        productList = ProductUtils.createProductList();
    }

    @AfterAll
    static void deleteProducts() {
        productList = null;
    }

    @Test
    void findById() {
        Product product = new Product(15, "Миксер(Мешалка) для смешивания смесей 100*500", 84);
        Assertions.assertEquals(product, productDao.findById(15).get());
    }

    @Test
    void findAll() {
        Assertions.assertEquals(productList.size(), productDao.findAll().size());
        IntStream.range(0, productList.size())
                .forEach(i -> Assertions.assertEquals(productList.get(i), productDao.findAll().get(i)));
    }
}