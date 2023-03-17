package ru.clevertec.service;

class DiscountCardServiceTest {

//    static List<DiscountCard> discountCardList;
//    private final DiscountCardService discountCardService;
//
//    @BeforeAll
//    static void generateDiscountCards() {
//        discountCardList = DiscountCardUtils.createDiscountCardList();
//    }
//
//    @AfterAll
//    static void deleteDiscountCards() {
//        discountCardList = null;
//    }
//
//    @Test
//    void findOneByIdTest() {
//        DiscountCard discountCard = new DiscountCard(17, 5);
//        Assertions.assertEquals(discountCard, discountCardService.findOneById(17));
//    }
//
//    @Test
//    void findOneByIdTestForNull() {
//        Assertions.assertEquals(0, discountCardService.findOneById(1136).getId());
//        Assertions.assertEquals(0, discountCardService.findOneById(1136).getDiscount());
//    }
//
//    static IntStream generateMissingIds() {
//        return IntStream.range(31, 33);
//    }
//
//    @ParameterizedTest
//    @MethodSource("generateMissingIds")
//    void findOneByIdTestForNull1(Integer missingId) {
//        Assertions.assertEquals(0, discountCardService.findOneById(missingId).getId());
//        Assertions.assertEquals(0, discountCardService.findOneById(missingId).getDiscount());
//    }
//
//    @Test
//    void findAllTest() {
//        String pageSize = "30";
//        List<DiscountCard> cards = discountCardService.findAll(pageSize, null);
//        Assertions.assertEquals(discountCardList.size(), cards.size());
//        IntStream.range(0, Integer.parseInt(pageSize))
//                .forEach(i -> Assertions.assertEquals(discountCardList.get(i), cards.get(i)));
//    }
//
//    @Test
//    @Disabled
//    void save() {
//        DiscountCard discountCard = new DiscountCard();
//        discountCard.setDiscount(15);
//        discountCardService.save(discountCard);
//        System.out.println(discountCard);
//    }
//
//    @Test
//    @Disabled
//    void update() {
//        DiscountCard discountCard = new DiscountCard();
//        discountCard.setDiscount(20);
//        discountCardService.update(discountCard, 32);
//        System.out.println(discountCard);
//    }
//
//    @Test
//    @Disabled
//    void remove() {
//        discountCardService.remove(32);
//    }
}