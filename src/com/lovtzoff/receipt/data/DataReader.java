package com.lovtzoff.receipt.data;

import java.util.List;

/**
 * Интерфейс чтения данных из текстовых файлов.
 *
 * @author Ловцов Алексей
 */
public interface DataReader {

    /**
     * Получить список строк с информацией о товарах.
     *
     * @return список строк с информацией о товарах
     */
    List<String> getProducts();

    /**
     * Получить список строк с информацией о скидочных картах.
     *
     * @return список строк с информацией о скидочных картах
     */
    List<String> getDiscountCard();
}
