package ru.clevertec.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.clevertec.dto.ProductDto;
import ru.clevertec.exception.ParameterNotFoundException;
import ru.clevertec.mapper.ProductMapper;
import ru.clevertec.util.TestDataUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Тесты сервиса для продуктов.
 */
@SpringBootTest
public class ProductServiceTest {

    /**
     * Сервис для продуктов.
     */
    @Autowired
    private ProductService productService;
    /**
     * Тестовый список продуктов.
     */
    static List<ProductDto> productList;

    /**
     * Сгенерировать список продуктов.
     */
    @BeforeAll
    static void generateProducts() {
        productList = TestDataUtils.createProductList().stream()
                .map(new ProductMapper()::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Удалить список продуктов.
     */
    @AfterAll
    static void deleteProducts() {
        productList = null;
    }

    /**
     * Тест поиска продукта по id.
     */
    @Test
    void findOneByIdTest() {
        ProductDto productDto = ProductDto.builder()
                .id(15)
                .name("Миксер(Мешалка) для смешивания смесей 100*500")
                .price(84.0)
                .build();
        Assertions.assertEquals(productDto, productService.findOneById(15));
    }

    /**
     * Тест поиска продукта по id с ошибкой.
     */
    @Test
    void findOneByIdFailedTest() {
        Assertions.assertThrows(ParameterNotFoundException.class, () -> productService.findOneById(1200));
    }

    /**
     * Тест поиска всех продуктов.
     */
    @Test
    void findAllTest() {
        String pageSize = "30";
        List<ProductDto> products = productService.findAll(pageSize, null);
        Assertions.assertEquals(productList.size(), products.size());
        IntStream.range(0, Integer.parseInt(pageSize))
                .forEach(i -> Assertions.assertEquals(productList.get(i), products.get(i)));
    }

    /**
     * Тест методов сохранения, обновления и удаления продукта.
     */
    @Test
    void testSaveUpdateRemoveMethods() {
        // save method test
        ProductDto productDto = ProductDto.builder()
                .name("Вагонка СЛ (Осина) СОРТ \"АВ\" 16х94(85)х2000мм (8шт.)")
                .price(26.84)
                .build();
        productDto = productService.save(productDto);
        int productId = productDto.getId();
        Assertions.assertEquals(productDto, productService.findOneById(productId));

        // update method test
        productDto.setName("Брусок профилированный обрезной сухой береза 15х40х2000 мм");
        productDto.setPrice(1.94);
        productDto = productService.update(productDto, productId);
        Assertions.assertEquals(productDto, productService.findOneById(productId));

        // remove method test
        productService.remove(productId);
        Assertions.assertThrows(ParameterNotFoundException.class, () -> productService.findOneById(productId));
    }
}