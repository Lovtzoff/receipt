package ru.clevertec.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.clevertec.dto.DiscountCardDto;
import ru.clevertec.exception.ParameterNotFoundException;
import ru.clevertec.mapper.DiscountCardMapper;
import ru.clevertec.util.TestDataUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Тесты сервиса для дисконтных карт.
 */
@SpringBootTest
class DiscountCardServiceTest {

    /**
     * Сервис для дисконтных карт.
     */
    @Autowired
    private DiscountCardService discountCardService;
    /**
     * Тестовый список дисконтных карт.
     */
    static List<DiscountCardDto> discountCardList;

    /**
     * Сгенерировать список карт.
     */
    @BeforeAll
    static void generateDiscountCards() {
        discountCardList = TestDataUtils.createDiscountCardList().stream()
                .map(new DiscountCardMapper()::toDto)
                .collect(Collectors.toList());
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
        DiscountCardDto discountCard = DiscountCardDto.builder()
                .id(17)
                .discount(5)
                .build();
        Assertions.assertEquals(discountCard, discountCardService.findOneById(17));
    }

    /**
     * Тест поиска карты по id с ошибкой.
     */
    @Test
    void findOneByIdFailedTest() {
        Assertions.assertThrows(ParameterNotFoundException.class, () -> discountCardService.findOneById(1136));
    }

    /**
     * Генерация отсутствующих идентификаторов.
     *
     * @return the int stream
     */
    static IntStream generateMissingIds() {
        return IntStream.range(1100, 1110);
    }

    /**
     * Параметризованный тест поиска карты по id с ошибкой.
     *
     * @param missingId the missing id
     */
    @ParameterizedTest
    @MethodSource("generateMissingIds")
    void findOneByIdFailedTest1(Integer missingId) {
        Assertions.assertThrows(ParameterNotFoundException.class, () -> discountCardService.findOneById(missingId));
    }

    /**
     * Тест поиска всех карт.
     */
    @Test
    void findAllTest() {
        String pageSize = "30";
        List<DiscountCardDto> cards = discountCardService.findAll(pageSize, null);
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
        DiscountCardDto discountCardDto = DiscountCardDto.builder()
                .discount(15)
                .build();
        discountCardDto = discountCardService.save(discountCardDto);
        int cardId = discountCardDto.getId();
        Assertions.assertEquals(discountCardDto, discountCardService.findOneById(cardId));

        // update method test
        discountCardDto.setDiscount(20);
        discountCardDto = discountCardService.update(discountCardDto, cardId);
        Assertions.assertEquals(discountCardDto, discountCardService.findOneById(cardId));

        // remove method test
        discountCardService.remove(cardId);
        Assertions.assertThrows(ParameterNotFoundException.class, () -> discountCardService.findOneById(cardId));
    }
}