package ru.clevertec.dao;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.clevertec.model.DiscountCard;
import ru.clevertec.util.DiscountCardUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static ru.clevertec.constants.Constants.DEFAULT_PAGE;

@SpringBootTest(classes = ru.clevertec.config.ApplicationConfiguration.class)
class DiscountCardDaoTest {

    @Autowired
    private DiscountCardDao discountCardDao;
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
    void testAddUpdateDeleteMethods() {
        // add method test
        DiscountCard discountCard = new DiscountCard();
        discountCard.setDiscount(15);
        discountCardDao.add(discountCard);
        int cardId = discountCard.getId();
        Assertions.assertEquals(discountCard, discountCardDao.findById(cardId).get());

        // update method test
        discountCard.setDiscount(20);
        discountCardDao.update(discountCard, cardId);
        Assertions.assertEquals(discountCard, discountCardDao.findById(cardId).get());

        // delete method test
        discountCardDao.delete(cardId);
        Assertions.assertEquals(Optional.empty(), discountCardDao.findById(cardId));
    }
}