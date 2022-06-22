package ru.clevertec.util;

import ru.clevertec.model.DiscountCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, содержащий утилиты для класса DiscountCard.
 */
public class DiscountCardUtils {

    /**
     * Создать список дисконтных карт.
     *
     * @return список карт
     */
    public static List<DiscountCard> createDiscountCardList() {
        List<DiscountCard> discountCardList = new ArrayList<>(30);
        discountCardList.add(new DiscountCard(1201,3));
        discountCardList.add(new DiscountCard(1202,5));
        discountCardList.add(new DiscountCard(1203,1));
        discountCardList.add(new DiscountCard(1204,2));
        discountCardList.add(new DiscountCard(1205,6));
        discountCardList.add(new DiscountCard(1206,7));
        discountCardList.add(new DiscountCard(1207,8));
        discountCardList.add(new DiscountCard(1208,10));
        discountCardList.add(new DiscountCard(1209,0));
        discountCardList.add(new DiscountCard(1210,2));
        discountCardList.add(new DiscountCard(1211,1));
        discountCardList.add(new DiscountCard(1212,0));
        discountCardList.add(new DiscountCard(1213,0));
        discountCardList.add(new DiscountCard(1214,2));
        discountCardList.add(new DiscountCard(1215,7));
        discountCardList.add(new DiscountCard(1216,9));
        discountCardList.add(new DiscountCard(1217,5));
        discountCardList.add(new DiscountCard(1218,1));
        discountCardList.add(new DiscountCard(1219,10));
        discountCardList.add(new DiscountCard(1220,6));
        discountCardList.add(new DiscountCard(1221,1));
        discountCardList.add(new DiscountCard(1222,0));
        discountCardList.add(new DiscountCard(1223,4));
        discountCardList.add(new DiscountCard(1224,2));
        discountCardList.add(new DiscountCard(1225,8));
        discountCardList.add(new DiscountCard(1226,3));
        discountCardList.add(new DiscountCard(1227,0));
        discountCardList.add(new DiscountCard(1228,2));
        discountCardList.add(new DiscountCard(1229,4));
        discountCardList.add(new DiscountCard(1230,1));
        return discountCardList;
    }
}
