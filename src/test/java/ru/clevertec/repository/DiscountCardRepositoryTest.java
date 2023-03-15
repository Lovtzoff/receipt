package ru.clevertec.repository;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.*;
import ru.clevertec.model.DiscountCard;
import ru.clevertec.util.DiscountCardUtils;

import java.util.List;
import java.util.stream.IntStream;

import static ru.clevertec.constants.Constants.DEFAULT_PAGE;

@RequiredArgsConstructor
class DiscountCardRepositoryTest {

    private final DiscountCardRepository discountCardRepository;
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
        Assertions.assertEquals(discountCard, discountCardRepository.findById(10).get());
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
    @Disabled
    void add() {
        DiscountCard discountCard = new DiscountCard();
        discountCard.setDiscount(15);
        discountCardRepository.add(discountCard);
        System.out.println(discountCard);
    }

    @Test
    @Disabled
    void update() {
        DiscountCard discountCard = new DiscountCard();
        discountCard.setDiscount(20);
        discountCardRepository.update(discountCard, 31);
        System.out.println(discountCard);
    }

    @Test
    @Disabled
    void delete() {
        discountCardRepository.delete(31);
    }
}