package ru.clevertec.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.clevertec.model.DiscountCard;
import ru.clevertec.util.DiscountCardUtils;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Тесты сервиса для дисконтных карт.
 */
@SpringBootTest(classes = ru.clevertec.config.ApplicationConfiguration.class)
class DiscountCardServiceTest {

    /**
     * Сервис для дисконтных карт.
     */
    @Autowired
    private DiscountCardService discountCardService;
    /**
     * Тестовый список дисконтных карт.
     */
    static List<DiscountCard> discountCardList;

    /**
     * Сгенерировать список карт.
     */
    @BeforeAll
    static void generateDiscountCards() {
        discountCardList = DiscountCardUtils.createDiscountCardList();
    }

    /**
     * Удалить список карт.
     */
    @AfterAll
    static void deleteDiscountCards() {
        discountCardList = null;
    }

    /**
     * Тест поиска карты по id.
     */
    @Test
    void findOneByIdTest() {
        DiscountCard discountCard = new DiscountCard(17, 5);
        Assertions.assertEquals(discountCard, discountCardService.findOneById(17));
    }

    /**
     * Тест на ноль для поиска карты по id.
     */
    @Test
    void findOneByIdTestForNull() {
        Assertions.assertEquals(0, discountCardService.findOneById(1136).getId());
        Assertions.assertEquals(0, discountCardService.findOneById(1136).getDiscount());
    }

    /**
     * Генерация отсутствующих идентификаторов.
     *
     * @return the int stream
     */
    static IntStream generateMissingIds() {
        return IntStream.range(100, 110);
    }

    /**
     * Параметризованный тест на ноль для поиска карты по id.
     *
     * @param missingId the missing id
     */
    @ParameterizedTest
    @MethodSource("generateMissingIds")
    void findOneByIdTestForNull1(Integer missingId) {
        Assertions.assertEquals(0, discountCardService.findOneById(missingId).getId());
        Assertions.assertEquals(0, discountCardService.findOneById(missingId).getDiscount());
    }

    /**
     * Тест поиска всех карт.
     */
    @Test
    void findAllTest() {
        String pageSize = "30";
        List<DiscountCard> cards = discountCardService.findAll(pageSize, null);
        Assertions.assertEquals(discountCardList.size(), cards.size());
        IntStream.range(0, Integer.parseInt(pageSize))
                .forEach(i -> Assertions.assertEquals(discountCardList.get(i), cards.get(i)));
    }

    /**
     * Тест методов сохранения, обновления и удаления карты.
     */
    @Test
    void testSaveUpdateRemoveMethods() {
        // save method test
        DiscountCard discountCard = new DiscountCard();
        discountCard.setDiscount(15);
        discountCardService.save(discountCard);
        int cardId = discountCard.getId();
        Assertions.assertEquals(discountCard, discountCardService.findOneById(cardId));

        // update method test
        discountCard.setDiscount(20);
        discountCardService.update(discountCard, cardId);
        Assertions.assertEquals(discountCard, discountCardService.findOneById(cardId));

        // remove method test
        discountCardService.remove(cardId);
        Assertions.assertEquals(0, discountCardService.findOneById(cardId).getId());
        Assertions.assertEquals(0, discountCardService.findOneById(cardId).getDiscount());
    }
}