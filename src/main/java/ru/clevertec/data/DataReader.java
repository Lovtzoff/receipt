package ru.clevertec.data;

import java.util.List;

/**
 * Интерфейс чтения данных из текстовых файлов.
 *
 * @author Ловцов Алексей
 */
public interface DataReader {

    /**
     * Получить список строк с данными для regex.
     *
     * @return список строк с данными
     */
    List<String> getRegexData();
}
