package ru.clevertec.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.clevertec.data.impl.DataReaderImpl;
import ru.clevertec.exception.ParameterNotFoundException;
import ru.clevertec.model.Product;
import ru.clevertec.service.impl.ProductServiceImpl;
import ru.clevertec.util.ProductUtils;

import java.util.List;
import java.util.stream.IntStream;

public class ProductServiceTest {

    static List<Product> productList;
    ProductService productService = new ProductServiceImpl(new DataReaderImpl());

    @BeforeAll
    static void generateProducts() {
        productList = ProductUtils.createProductList();
    }

    @AfterAll
    static void deleteProducts() {
        productList = null;
    }

    @Test
    void findOneByIdTest() {
        Product product = new Product(15, "Миксер(Мешалка) для смешивания смесей 100*500", 84);
        Assertions.assertEquals(product, productService.findOneById(15));
    }

    @Test
    void findOneByIdFailedTest() {
        Assertions.assertThrows(
                ParameterNotFoundException.class,
                () -> productService.findOneById(50)
        );
    }

    @Test
    void findAllTest() {
        Assertions.assertEquals(productList.size(), productService.findAll().size());
        IntStream.range(0, productList.size())
                .forEach(i -> Assertions.assertEquals(productList.get(i), productService.findAll().get(i)));
    }
}