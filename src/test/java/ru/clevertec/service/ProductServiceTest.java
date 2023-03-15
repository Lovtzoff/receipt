package ru.clevertec.service;

import org.junit.jupiter.api.*;
import ru.clevertec.repository.impl.ProductDaoRepositoryImpl;
import ru.clevertec.exception.ParameterNotFoundException;
import ru.clevertec.model.Product;
import ru.clevertec.service.impl.ProductServiceImpl;
import ru.clevertec.util.ProductUtils;

import java.util.List;
import java.util.stream.IntStream;

public class ProductServiceTest {

    static List<Product> productList;
    ProductService productService = new ProductServiceImpl(new ProductDaoRepositoryImpl());

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
        Product product = new Product(15, "Миксер(Мешалка) для смешивания смесей 100*500", 84.0);
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
        String pageSize = "30";
        List<Product> products = productService.findAll(pageSize, null);
        Assertions.assertEquals(productList.size(), products.size());
        IntStream.range(0, Integer.parseInt(pageSize))
                .forEach(i -> Assertions.assertEquals(productList.get(i), products.get(i)));
    }

    @Test
    @Disabled
    void save() {
        Product product = new Product();
        product.setName("Вагонка СЛ (Осина) СОРТ \"АВ\" 16х94(85)х2000мм (8шт.)");
        product.setPrice(26.84);
        productService.save(product);
        System.out.println(product);
    }

    @Test
    @Disabled
    void update() {
        Product product = new Product();
        product.setName("Брусок профилированный обрезной сухой береза 15х40х2000 мм");
        product.setPrice(1.94);
        productService.update(product, 36);
        System.out.println(product);
    }

    @Test
    @Disabled
    void remove() {
        productService.remove(36);
    }
}