package ru.clevertec.constants;

/**
 * Класс, в котором хранятся постоянные переменные: пути, форматы времени и др.
 *
 * @author Ловцов Алексей
 */
public class Constants {

    private static final String DATA_DIR = "data";
    public static final String PRODUCT_LIST = DATA_DIR + "/catalog.list";
    public static final String CARD_LIST = DATA_DIR + "/card.list";
    public static final String SEPARATOR = ";";

    public static final String PRINT_DIR = "print";
    public static final String RECEIPT_FILE = PRINT_DIR + "/receipt.print";

    public static final String ARG_SEPARATOR = "-";

    public static final String DATE_PATTERN = "dd/MM/yyyy";
    public static final String TIME_PATTERN = "HH:mm:ss";

    public static final int COUNT_DEFAULT = 1;
    public static final int SCALE_DEFAULT = 3;

    private static final String REGEX_DIR = DATA_DIR + "/regex";
    public static final String REGEX_DATA_LIST = REGEX_DIR + "/regexData.txt";
    public static final String INVALID_DATA_LIST = REGEX_DIR + "/invalidRegexData.txt";
    public static final String VALID_DATA_LIST = REGEX_DIR + "/validRegexData.txt";
}
