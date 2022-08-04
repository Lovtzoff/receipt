package ru.clevertec.dao;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.clevertec.dao.impl.DiscountCardDaoImpl;
import ru.clevertec.model.DiscountCard;
import ru.clevertec.util.DiscountCardUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
        Assertions.assertEquals(discountCardList.size(), discountCardDao.findAll().size());
        IntStream.range(0, discountCardList.size())
                .forEach(i -> Assertions.assertEquals(discountCardList.get(i), discountCardDao.findAll().get(i)));
    }
}