package ru.clevertec.controller.servlets.receipt;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import ru.clevertec.exception.ParameterNotFoundException;
import ru.clevertec.model.Receipt;
import ru.clevertec.service.ReceiptService;
import ru.clevertec.validation.ParameterValidator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import static ru.clevertec.constants.Constants.RECEIPT_PDF;
import static ru.clevertec.constants.Constants.STRING_SEPARATOR;

@Component
@RequiredArgsConstructor
public class GetReceiptServlet extends HttpServlet {

    private final ReceiptService receiptService;

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String source = req.getParameter("source");
        String[] parameters = source.split(STRING_SEPARATOR);
        try {
            ParameterValidator.isValid(parameters);
            Receipt receipt = receiptService.generateReceipt(parameters);
            receiptService.printReceipt(receipt);
            try (OutputStream writer2 = resp.getOutputStream()) {
                writer2.write(Files.readAllBytes(Paths.get(RECEIPT_PDF).toAbsolutePath()));
            }
        } catch (ParameterNotFoundException ex) {
            resp.setContentType("application/json");
            String json = new Gson().toJson("Message: " + ex.getMessage());
            try (PrintWriter writer = resp.getWriter()) {
                writer.write(json);
                resp.setStatus(404);
            }
        }

    }
}
