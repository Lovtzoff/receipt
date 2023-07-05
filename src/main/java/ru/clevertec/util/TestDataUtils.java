package ru.clevertec.util;

import ru.clevertec.constants.Constants;
import ru.clevertec.model.*;
import ru.clevertec.util.NumberUtils;
import ru.clevertec.util.RoundingUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Класс, содержащий методы для получения тестовых данных.
 *
 * @author Lovtsov Aliaksei
 */
public class TestDataUtils {

    /**
     * Создать список дисконтных карт.
     *
     * @return список карт
     */
    public static List<DiscountCard> createDiscountCardList() {
        List<DiscountCard> discountCardList = new ArrayList<>(30);
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
        return discountCardList;
    }

    /**
     * Создать список продуктов.
     *
     * @return список продуктов
     */
    public static List<Product> createProductList() {
        List<Product> productList = new ArrayList<>(30);

        productList.add(new Product(1, "Арматура 8мм А3 (1п.м.)", 12.0));
        productList.add(new Product(2, "Болт оцинкованный М8х80 (50шт.уп.)", 104.0));
        productList.add(new Product(3, "Бумага наждачная шлифовальная М40 (1 п.м.)", 88.0));
        productList.add(new Product(4, "Гайка М6 шестигранная оцинкованная (450шт.уп.)", 72.0));
        productList.add(new Product(5, "Гвозди строительные 3x70мм", 32.0));
        productList.add(new Product(6, "Гофра к унитазу 1м.", 92.0));
        productList.add(new Product(7, "Грунт-эмаль по ржавчине - Синяя (ведро 20кг)", 1199.6));
        productList.add(
                new Product(
                        8,
                        "Кирпич лицевой одинарный (размер 250х120х65) М150 цвет абрикос",
                        10.0
                )
        );
        productList.add(new Product(9, "Кирпич строительный двойной щелевой М150 (250х120х130мм)", 6.8));
        productList.add(new Product(10, "Клей монтажный КНАУФ Перлфикс / KNAUF Perlfix (30 кг.)", 132.0));
        productList.add(new Product(11, "Клейкая лента фольгированная алюминиевая", 60.0));
        productList.add(
                new Product(
                        12,
                        "КНАУФ Тифенгрунд / KNAUF Tiefengrund грунтовка универсальная (10л)",
                        300.0
                )
        );
        productList.add(
                new Product(
                        13,
                        "Коллектор с вентильными кранами (Comisa) 3\\4-1\\2, 4 выхода (88.20.060)",
                        360.0
                )
        );
        productList.add(new Product(14, "Кран шаровой ф50 (4SPK0766)", 260.0));
        productList.add(new Product(15, "Миксер(Мешалка) для смешивания смесей 100*500", 84.0));
        productList.add(new Product(16, "Пена монтажная Титан для блоков 750 мл.", 180.0));
        productList.add(
                new Product(
                        17,
                        "ПЕНОПЛЭКС КРОВЛЯ (пл.35 ) 1200х600х50мм 5.76 м2, 0.288 м3, (8 шт)",
                        592.0
                )
        );
        productList.add(new Product(18, "Перфоратор Макита HR2450 780 Вт.", 3396.0));
        productList.add(new Product(19, "ПЕРЧАТКИ рабочие трикотажные с точечным покрытием", 8.0));
        productList.add(new Product(20, "Просечка ЦПВС штукатурная, размер 1х10м (10м2)", 100.0));
        productList.add(
                new Product(
                        21,
                        "Радиатор биметаллический XTREME 500*100 (12секций) Италия",
                        4200.0
                )
        );
        productList.add(new Product(22, "Саморезы по дереву 3.8х55", 100.0));
        productList.add(new Product(23, "Саморезы с прессшайбой 4,2 х 16 острый наконечник", 112.0));
        productList.add(new Product(24, "Тачка строительная 2 колесная 110л", 1400.0));
        productList.add(
                new Product(
                        25,
                        "ТИККУРИЛА Евро 2 / TIKKURILA Euro 2 краска матовая латексная (9 л)",
                        980.0
                )
        );
        productList.add(new Product(26, "Уголок металлический 32 мм (1 п.м.)", 48.0));
        productList.add(
                new Product(
                        27,
                        "Утеплитель Роквул (Rockwool) Лайт Баттс Скандик 5.76м2 (0.288м3) 800*600*50мм",
                        180.0
                )
        );
        productList.add(
                new Product(
                        28,
                        "Фильтр промывной для холодной воды с регулятором давления Honeywell FK06-3\\4AA(100мк.)",
                        1684.0
                )
        );
        productList.add(new Product(29, "ХЕБЕЛЬ / HEBEL пеноблок 250х600 толщина 100 мм", 28.8));
        productList.add(
                new Product(
                        30,
                        "ЦЕРЕЗИТ СТ 17 / CERESIT CT 17 грунт универсальный (10 л)",
                        231.6
                )
        );
        return productList;
    }

    /**
     * Создать квитанцию.
     *
     * @param sourceArray исходный массив
     * @return квитанция
     */
    public static Receipt createReceipt(String[] sourceArray) {
        List<Products> productsList = new ArrayList<>();
        DiscountCard discountCard = new DiscountCard();
        for (String arg : sourceArray) {
            String[] array = arg.split(Constants.ARG_SEPARATOR);
            if (NumberUtils.isNumeric(array[0])) {
                Product product = createProductList().stream()
                        .filter(productItem -> productItem.getId().equals(Integer.parseInt(array[0])))
                        .findFirst()
                        .get();
                int count = Integer.parseInt(array[1]);
                productsList.add(new Products(count, product, count * product.getPrice()));
            } else if (array[0].equals("card")) {
                discountCard = createDiscountCardList().stream()
                        .filter(card -> card.getId().equals(Integer.parseInt(array[1])))
                        .findFirst()
                        .get();
            }
        }

        double totalNoDiscount = productsList.stream().mapToDouble(Products::getTotalPrice).sum();
        double discount = (totalNoDiscount * discountCard.getDiscount()) / 100;
        double totalWithDiscount = (discount != 0) ? (totalNoDiscount - discount) : totalNoDiscount;

        return new Receipt(
                new Header(),
                new Cashier(Constants.ID_CASHIER_DEFAULT),
                new SimpleDateFormat(Constants.DATE_PATTERN).format(new Date()),
                new SimpleDateFormat(Constants.TIME_PATTERN).format(new Date()),
                productsList,
                RoundingUtils.round(totalNoDiscount),
                RoundingUtils.round(discount),
                RoundingUtils.round(totalWithDiscount)
        );
    }
}
