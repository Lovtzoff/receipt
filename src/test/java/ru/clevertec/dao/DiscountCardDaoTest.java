package ru.clevertec.dao;

import org.junit.jupiter.api.*;
import ru.clevertec.dao.impl.DiscountCardDaoImpl;
import ru.clevertec.model.DiscountCard;
import ru.clevertec.util.DiscountCardUtils;

import java.util.List;
import java.util.stream.IntStream;

import static ru.clevertec.constants.Constants.DEFAULT_PAGE;

class DiscountCardDaoTest {

    private final DiscountCardDao discountCardDao = new DiscountCardDaoImpl();
    static List<DiscountCard> discountCardList;

    @BeforeAll
    static void generateDiscountCards() {
        discountCardList = DiscountCardUtils.createDiscountCardList();
    }

    @AfterAll
    static void deleteDiscountCards() {
        discountCardList = null;
    }

    @Test
    void findById() {
        DiscountCard discountCard = new DiscountCard(10, 9);
        Assertions.assertEquals(discountCard, discountCardDao.findById(10).get());
    }

    @Test
    void findAll() {
        int pageSize = 30;
        List<DiscountCard> cards = discountCardDao.findAll(pageSize, DEFAULT_PAGE);
        Assertions.assertEquals(discountCardList.size(), cards.size());
        IntStream.range(0, pageSize)
                .forEach(i -> Assertions.assertEquals(discountCardList.get(i), cards.get(i)));
    }

    @Test
    @Disabled
    void add() {
        DiscountCard discountCard = new DiscountCard();
        discountCard.setDiscount(15);
        discountCardDao.add(discountCard);
        System.out.println(discountCard);
    }

    @Test
    @Disabled
    void update() {
        DiscountCard discountCard = new DiscountCard();
        discountCard.setDiscount(20);
        discountCardDao.update(discountCard, 31);
        System.out.println(discountCard);
    }

    @Test
    @Disabled
    void delete() {
        discountCardDao.delete(31);
    }
}