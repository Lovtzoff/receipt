package ru.clevertec.repository;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.clevertec.model.Product;
import ru.clevertec.util.ProductUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static ru.clevertec.constants.Constants.DEFAULT_PAGE;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;
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
        Product product = new Product(15, "Миксер(Мешалка) для смешивания смесей 100*500", 84.0);
        Product productTest = productRepository.findById(15).get();
        Assertions.assertEquals(product, productTest);
    }

    @Test
    void findAll() {
        int pageSize = 30;
        List<Product> products = productRepository.findAll(pageSize, DEFAULT_PAGE);
        Assertions.assertEquals(productList.size(), products.size());
        IntStream.range(0, pageSize)
                .forEach(i -> Assertions.assertEquals(productList.get(i), products.get(i)));
    }

    @Test
    void testAddUpdateDeleteMethods() {
        // add method test
        Product product = new Product();
        product.setName("Вагонка СЛ (Осина) СОРТ \"АВ\" 16х94(85)х2000мм (8шт.)");
        product.setPrice(26.84);
        productRepository.add(product);
        int productId = product.getId();
        Assertions.assertEquals(product, productRepository.findById(productId).get());

        // update method test
        product.setName("Брусок профилированный обрезной сухой береза 15х40х2000 мм");
        product.setPrice(1.94);
        productRepository.update(product, productId);
        Assertions.assertEquals(product, productRepository.findById(productId).get());

        // delete method test
        productRepository.delete(productId);
        Assertions.assertEquals(Optional.empty(), productRepository.findById(productId));
    }
}