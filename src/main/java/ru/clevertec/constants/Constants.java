package ru.clevertec.constants;

/**
 * Класс, в котором хранятся постоянные переменные: пути, форматы времени и др.
 *
 * @author Ловцов Алексей
 */
public class Constants {

    public static final String PRINT_DIR = "print";
    public static final String RECEIPT_FILE = PRINT_DIR + "/receipt.print";
    public static final String RECEIPT_PDF = PRINT_DIR + "/receipt.pdf";

    public static final String ARG_SEPARATOR = "-";
    public static final String STRING_SEPARATOR = " ";

    public static final String DATE_PATTERN = "dd/MM/yyyy";
    public static final String TIME_PATTERN = "HH:mm:ss";

    public static final int COUNT_DEFAULT = 1;
    public static final int SCALE_DEFAULT = 3;

    public static final int ID_CASHIER_DEFAULT = 32;

    public static final String FONT_COURIER = "font/Courier10 Cyr BT.ttf";

    public static final int DEFAULT_SIZE_PAGE = 20;
    public static final int DEFAULT_PAGE = 0;
}
