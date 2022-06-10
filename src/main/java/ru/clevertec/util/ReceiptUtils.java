package ru.clevertec.util;

import ru.clevertec.constants.Constants;
import ru.clevertec.model.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Класс, содержащий утилиты для класса Receipt.
 */
public class ReceiptUtils {

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
                Product product = ProductUtils.createProductList().stream()
                        .filter(productItem -> productItem.getId().equals(Integer.parseInt(array[0])))
                        .findFirst()
                        .get();
                int count = Integer.parseInt(array[1]);
                productsList.add(new Products(count, product, count * product.getPrice()));
            } else if (array[0].equals("card")) {
                discountCard = DiscountCardUtils.createDiscountCardList().stream()
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
