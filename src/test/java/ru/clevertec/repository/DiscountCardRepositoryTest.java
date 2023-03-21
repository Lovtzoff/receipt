package ru.clevertec.repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.clevertec.model.DiscountCard;
import ru.clevertec.util.DiscountCardUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static ru.clevertec.constants.Constants.DEFAULT_PAGE;

@SpringBootTest
class DiscountCardRepositoryTest {

    @Autowired
    private DiscountCardRepository discountCardRepository;
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
        DiscountCard discountCardTest = discountCardRepository.findById(10).get();
        Assertions.assertEquals(discountCard, discountCardTest);
    }

    @Test
    void findAll() {
        int pageSize = 30;
        List<DiscountCard> cards = discountCardRepository.findAll(pageSize, DEFAULT_PAGE);
        Assertions.assertEquals(discountCardList.size(), cards.size());
        IntStream.range(0, pageSize)
                .forEach(i -> Assertions.assertEquals(discountCardList.get(i), cards.get(i)));
    }

    @Test
    void testAddUpdateDeleteMethods() {
        // add method test
        DiscountCard discountCard = new DiscountCard();
        discountCard.setDiscount(15);
        discountCardRepository.add(discountCard);
        int cardId = discountCard.getId();
        Assertions.assertEquals(discountCard, discountCardRepository.findById(cardId).get());

        // update method test
        discountCard.setDiscount(20);
        discountCardRepository.update(discountCard, cardId);
        Assertions.assertEquals(discountCard, discountCardRepository.findById(cardId).get());

        // delete method test
        discountCardRepository.delete(cardId);
        Assertions.assertEquals(Optional.empty(), discountCardRepository.findById(cardId));
    }
}