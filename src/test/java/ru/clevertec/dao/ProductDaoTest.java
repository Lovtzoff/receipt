package ru.clevertec.dao;

import org.junit.jupiter.api.*;
import ru.clevertec.dao.impl.ProductDaoImpl;
import ru.clevertec.model.Product;
import ru.clevertec.util.ProductUtils;

import java.util.List;
import java.util.stream.IntStream;

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

    @Test
    @Disabled
    void add() {
        Product product = new Product();
        product.setName("Вагонка СЛ (Осина) СОРТ \"АВ\" 16х94(85)х2000мм (8шт.)");
        product.setPrice(26.84);
        productDao.add(product);
        System.out.println(product);
    }

    @Test
    @Disabled
    void update() {
        Product product = new Product();
        product.setName("Брусок профилированный обрезной сухой береза 15х40х2000 мм");
        product.setPrice(1.94);
        productDao.update(product, 36);
        System.out.println(product);
    }

    @Test
    @Disabled
    void delete() {
        productDao.delete(36);
    }
}