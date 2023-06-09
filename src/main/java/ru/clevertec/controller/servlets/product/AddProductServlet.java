package ru.clevertec.controller.servlets.product;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import ru.clevertec.dto.ProductDto;
import ru.clevertec.service.ProductService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
@RequiredArgsConstructor
public class AddProductServlet extends HttpServlet {

    private final ProductService productService;

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        Double price = Double.valueOf(req.getParameter("price"));
        ProductDto productDto = ProductDto.builder()
                .name(name)
                .price(price)
                .build();
        productDto = productService.save(productDto);
        String json = new Gson().toJson(productDto);
        try (PrintWriter writer = resp.getWriter()) {
            writer.write(json);
            resp.setStatus(201);
        }
    }
}
