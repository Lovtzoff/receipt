package ru.clevertec.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.model.Receipt;
import ru.clevertec.service.ReceiptService;
import ru.clevertec.validation.ParameterValidator;

import javax.websocket.server.PathParam;
import java.io.File;
import java.nio.file.Files;

import static ru.clevertec.constants.Constants.RECEIPT_PDF;
import static ru.clevertec.constants.Constants.STRING_SEPARATOR;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReceiptController {

    private final ReceiptService receiptService;

    @SneakyThrows
    @GetMapping("/getReceipt")
    public ResponseEntity<InputStreamResource> getReceipt(@PathParam("source") String source) {
        String[] parameters = source.split(STRING_SEPARATOR);
        ParameterValidator.isValid(parameters);
        Receipt receipt = receiptService.generateReceipt(parameters);
        receiptService.printReceipt(receipt);

        File file = new File(RECEIPT_PDF);
        InputStreamResource resource = new InputStreamResource(Files.newInputStream(file.toPath()));

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(file.length())
                .body(resource);
    }
}
