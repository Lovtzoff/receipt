package ru.clevertec.service.impl;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import com.wagu.Block;
import com.wagu.Board;
import com.wagu.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.clevertec.exception.ParameterNotFoundException;
import ru.clevertec.model.*;
import ru.clevertec.repository.DiscountCardRepository;
import ru.clevertec.repository.ProductRepository;
import ru.clevertec.service.ReceiptService;
import ru.clevertec.util.NumberUtils;
import ru.clevertec.util.RoundingUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static ru.clevertec.constants.Constants.*;

/**
 * Реализация интерфейса ReceiptService.
 *
 * @author Ловцов Алексей
 * @see ReceiptService
 */
@Service
@RequiredArgsConstructor
public class ReceiptServiceImpl implements ReceiptService {

    private final ProductRepository productRepository;
    private final DiscountCardRepository discountCardRepository;

    @Override
    public Receipt generateReceipt(String[] args) {
        List<Products> productsList = new ArrayList<>();
        DiscountCard discountCard = new DiscountCard();
        for (String arg : args) {
            String[] array = arg.split(ARG_SEPARATOR);
            if (NumberUtils.isNumeric(array[0])) {
                Product product = productRepository.findById(Integer.parseInt(array[0]))
                        .orElseThrow(() -> new ParameterNotFoundException("Один из товаров отсутствует в базе!"));
                int count = (NumberUtils.isNumeric(array[1]) && Integer.parseInt(array[1]) != 0) ?
                        Integer.parseInt(array[1]) : COUNT_DEFAULT;
                productsList.add(
                        new Products(
                                count,
                                product,
                                count * product.getPrice()
                        )
                );
            } else if (array[0].equals("card")) {
                int cardId = NumberUtils.isNumeric(array[1]) ? Integer.parseInt(array[1]) : 0;
                discountCard = discountCardRepository.findById(cardId).orElse(new DiscountCard());
            }
        }
        double totalNoDiscount = productsList.stream().mapToDouble(Products::getTotalPrice).sum();
        double discount = (totalNoDiscount * discountCard.getDiscount()) / 100;
        double totalWithDiscount = (discount != 0) ? (totalNoDiscount - discount) : totalNoDiscount;

        return new Receipt(
                new Header(),
                new Cashier(ID_CASHIER_DEFAULT),
                new SimpleDateFormat(DATE_PATTERN).format(new Date()),
                new SimpleDateFormat(TIME_PATTERN).format(new Date()),
                productsList,
                RoundingUtils.round(totalNoDiscount),
                RoundingUtils.round(discount),
                RoundingUtils.round(totalWithDiscount)
        );
    }

    @Override
    public void printReceipt(Receipt receipt) {
        String print = generateTable(receipt);
        System.out.println(print);

        try {
            Files.createDirectories(Paths.get(PRINT_DIR));
            Files.write(Paths.get(RECEIPT_FILE), print.getBytes());

            PdfDocument pdfDocument = new PdfDocument(new PdfWriter(RECEIPT_PDF));
            Document document = new Document(pdfDocument);
            PdfFont pdfFont = PdfFontFactory.createFont(FONT_COURIER, "Cp1251");
            Paragraph paragraph = new Paragraph().setFont(pdfFont);

            paragraph.add(print.replace("\u0020", "\u00A0"));
            document.setTextAlignment(TextAlignment.LEFT);
            document.setFontSize((float) 7.0);
            document.add(paragraph);
            document.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    /**
     * Создать строку таблицы.
     *
     * @param receipt the receipt
     * @return the string
     */
    private String generateTable(Receipt receipt) {
        String company = receipt.getHeader().toString();
        List<String> t1Headers = Arrays.asList("Cashier's number", "Date/Time");
        List<List<String>> t1Rows = Arrays.asList(
                Arrays.asList(receipt.getCashier().toString(), receipt.getPrintDate()),
                Arrays.asList(" ", receipt.getPrintTime())
        );
        String t2Desc = "SELLING DETAILS";
        List<String> t2Headers = Arrays.asList("QTE", "DESCRIPTION", "PRICE($)", "TOTAL($)");
        List<List<String>> t2Rows = new ArrayList<>();
        for (Products products : receipt.getProductsList()) {
            List<String> list = new ArrayList<>(4);
            list.add(String.valueOf(products.getCount()));
            list.add(products.getProduct().getProductName());
            list.add(String.valueOf(products.getProduct().getPrice()));
            list.add(String.valueOf(products.getTotalPrice()));
            t2Rows.add(list);
        }
        List<Integer> t2ColWidths = Arrays.asList(5, 90, 9, 12);
        String summary =
                "TOTAL NO DISCOUNT($): \n"
                        + "DISCOUNT($): \n"
                        + "TOTAL WITH DISCOUNT($): ";
        String summaryVal =
                receipt.getTotalNoDiscount() + "\n"
                        + receipt.getDiscount() + "\n"
                        + receipt.getTotalWithDiscount();

        Board board = new Board(121);
        board.setInitialBlock(
                new Block(
                        board,
                        119,
                        7,
                        company
                ).allowGrid(false).setBlockAlign(Block.BLOCK_CENTRE).setDataAlign(Block.DATA_CENTER)
        );
        board.appendTableTo(
                0,
                Board.APPEND_BELOW,
                new Table(board, 121, t1Headers, t1Rows)
        );
        board.getBlock(3).setBelowBlock(
                new Block(board, 119, 1, t2Desc).setDataAlign(Block.DATA_CENTER)
        );
        board.appendTableTo(
                5,
                Board.APPEND_BELOW,
                new Table(board, 121, t2Headers, t2Rows, t2ColWidths)
        );
        Block summaryBlock = new Block(
                board,
                108,
                4, summary
        ).allowGrid(false).setDataAlign(Block.DATA_MIDDLE_RIGHT);
        board.getBlock(10).setBelowBlock(summaryBlock);
        Block summaryValBlock = new Block(
                board,
                12,
                4,
                summaryVal
        ).allowGrid(false).setDataAlign(Block.DATA_MIDDLE_RIGHT);
        summaryBlock.setRightBlock(summaryValBlock);

        return board.invalidate().build().getPreview();
    }
}
