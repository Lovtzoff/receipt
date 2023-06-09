package ru.clevertec.controller.servlets.product;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import ru.clevertec.dto.ProductDto;
import ru.clevertec.exception.ParameterNotFoundException;
import ru.clevertec.service.ProductService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
@RequiredArgsConstructor
public class UpdateProductServlet extends HttpServlet {

    private final ProductService productService;

    @SneakyThrows
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        Double price = Double.valueOf(req.getParameter("price"));
        ProductDto productDto = ProductDto.builder()
                .name(name)
                .price(price)
                .build();
        try {
            productDto = productService.update(productDto, id);
            String json = new Gson().toJson(productDto);
            try (PrintWriter writer = resp.getWriter()) {
                writer.write(json);
                resp.setStatus(201);
            }
        } catch (ParameterNotFoundException ex) {
            String json = new Gson().toJson("Message: " + ex.getMessage());
            try (PrintWriter writer = resp.getWriter()) {
                writer.write(json);
                resp.setStatus(404);
            }
        }
    }
}
