package ru.clevertec.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.clevertec.dao.impl.DiscountCardDaoImpl;
import ru.clevertec.model.DiscountCard;
import ru.clevertec.service.impl.DiscountCardServiceImpl;
import ru.clevertec.util.DiscountCardUtils;

import java.util.List;
import java.util.stream.IntStream;

class DiscountCardServiceTest {

    static List<DiscountCard> discountCardList;
    DiscountCardService discountCardService = new DiscountCardServiceImpl(new DiscountCardDaoImpl());

    @BeforeAll
    static void generateDiscountCards() {
        discountCardList = DiscountCardUtils.createDiscountCardList();
    }

    @AfterAll
    static void deleteDiscountCards() {
        discountCardList = null;
    }

    @Test
    void findOneByIdTest() {
        DiscountCard discountCard = new DiscountCard(17, 5);
        Assertions.assertEquals(discountCard, discountCardService.findOneById(17));
    }

    @Test
    void findOneByIdTestForNull() {
        Assertions.assertEquals(0, discountCardService.findOneById(1136).getId());
        Assertions.assertEquals(0, discountCardService.findOneById(1136).getDiscount());
    }

    static IntStream generateMissingIds() {
        return IntStream.range(31, 33);
    }

    @ParameterizedTest
    @MethodSource("generateMissingIds")
    void findOneByIdTestForNull1(Integer missingId) {
        Assertions.assertEquals(0, discountCardService.findOneById(missingId).getId());
        Assertions.assertEquals(0, discountCardService.findOneById(missingId).getDiscount());
    }

    @Test
    void findAllTest() {
        Assertions.assertEquals(discountCardList.size(), discountCardService.findAll().size());
        IntStream.range(0, discountCardList.size())
                .forEach(i -> Assertions.assertEquals(discountCardList.get(i), discountCardService.findAll().get(i)));
    }

    @Test
    @Disabled
    void save() {
        DiscountCard discountCard = new DiscountCard();
        discountCard.setDiscount(15);
        discountCardService.save(discountCard);
        System.out.println(discountCard);
    }

    @Test
    @Disabled
    void update() {
        DiscountCard discountCard = new DiscountCard();
        discountCard.setDiscount(20);
        discountCardService.update(discountCard, 32);
        System.out.println(discountCard);
    }

    @Test
    @Disabled
    void remove() {
        discountCardService.remove(32);
    }
}