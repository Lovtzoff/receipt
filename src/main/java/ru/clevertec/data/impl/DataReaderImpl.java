package ru.clevertec.data.impl;

import ru.clevertec.data.DataReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import static ru.clevertec.constants.Constants.*;

/**
 * Реализация интерфейса DataReader.
 *
 * @author Ловцов Алексей
 * @see DataReader
 */
public class DataReaderImpl implements DataReader {

    @Override
    public List<String> getProducts() {
        return readAllLines(PRODUCT_LIST);
    }

    @Override
    public List<String> getDiscountCard() {
        return readAllLines(CARD_LIST);
    }

    @Override
    public List<String> getRegexData() {
        return readAllLines(REGEX_DATA_LIST);
    }

    //----------------------------------------------------------------------------------------

    /**
     * Прочитать все строки и вернуть их список.
     *
     * @param filePath путь к файлу
     * @return список строк
     */
    private List<String> readAllLines(String filePath) {
        try {
            List<String> lineList = Files.readAllLines(Paths.get(filePath));
            lineList.removeIf(item -> item.startsWith("#"));
            lineList.removeIf(item -> item.equals(""));
            return lineList;
        } catch (IOException ex) {
            System.out.println("Error: Отсутствует файл - " + ex.getMessage());
        }
        return Collections.emptyList();
    }
}
