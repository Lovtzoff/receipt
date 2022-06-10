package ru.clevertec.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.clevertec.data.impl.DataReaderImpl;
import ru.clevertec.model.DiscountCard;
import ru.clevertec.service.impl.DiscountCardServiceImpl;
import ru.clevertec.util.DiscountCardUtils;

import java.util.List;
import java.util.stream.IntStream;

class DiscountCardServiceTest {

    static List<DiscountCard> discountCardList;
    DiscountCardService discountCardService = new DiscountCardServiceImpl(new DataReaderImpl());

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
        DiscountCard discountCard = new DiscountCard(1210, 2);
        Assertions.assertEquals(discountCard, discountCardService.findOneById(1210));
    }

    @Test
    void findOneByIdTestForNull() {
        Assertions.assertNull(discountCardService.findOneById(1136).getId());
        Assertions.assertNull(discountCardService.findOneById(1136).getDiscount());
    }

    static IntStream generateMissingIds(){
        return IntStream.range(0, 1200);
    }

    @ParameterizedTest
    @MethodSource("generateMissingIds")
    void findOneByIdTestForNull1(Integer missingId) {
        Assertions.assertNull(discountCardService.findOneById(missingId).getId());
        Assertions.assertNull(discountCardService.findOneById(missingId).getDiscount());
    }

    @Test
    void findAllTest() {
        Assertions.assertEquals(discountCardList.size(), discountCardService.findAll().size());
        IntStream.range(0, discountCardList.size())
                .forEach(i -> Assertions.assertEquals(discountCardList.get(i), discountCardService.findAll().get(i)));
    }
}