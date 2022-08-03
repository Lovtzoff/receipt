package ru.clevertec.dao;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.clevertec.dao.impl.DiscountCardDaoImpl;
import ru.clevertec.model.DiscountCard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class DiscountCardDaoTest {

    private final DiscountCardDao discountCardDao = new DiscountCardDaoImpl();
    static List<DiscountCard> discountCardList;

    @BeforeAll
    static void generateDiscountCards() {
        discountCardList = new ArrayList<>(30);
        discountCardList.add(new DiscountCard(1, 3));
        discountCardList.add(new DiscountCard(2, 5));
        discountCardList.add(new DiscountCard(3, 1));
        discountCardList.add(new DiscountCard(4, 2));
        discountCardList.add(new DiscountCard(5, 6));
        discountCardList.add(new DiscountCard(6, 7));
        discountCardList.add(new DiscountCard(7, 8));
        discountCardList.add(new DiscountCard(8, 10));
        discountCardList.add(new DiscountCard(9, 4));
        discountCardList.add(new DiscountCard(10, 9));
        discountCardList.add(new DiscountCard(11, 1));
        discountCardList.add(new DiscountCard(12, 4));
        discountCardList.add(new DiscountCard(13, 3));
        discountCardList.add(new DiscountCard(14, 2));
        discountCardList.add(new DiscountCard(15, 7));
        discountCardList.add(new DiscountCard(16, 9));
        discountCardList.add(new DiscountCard(17, 5));
        discountCardList.add(new DiscountCard(18, 8));
        discountCardList.add(new DiscountCard(19, 10));
        discountCardList.add(new DiscountCard(20, 6));
        discountCardList.add(new DiscountCard(21, 7));
        discountCardList.add(new DiscountCard(22, 6));
        discountCardList.add(new DiscountCard(23, 4));
        discountCardList.add(new DiscountCard(24, 8));
        discountCardList.add(new DiscountCard(25, 10));
        discountCardList.add(new DiscountCard(26, 1));
        discountCardList.add(new DiscountCard(27, 2));
        discountCardList.add(new DiscountCard(28, 5));
        discountCardList.add(new DiscountCard(29, 9));
        discountCardList.add(new DiscountCard(30, 3));
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