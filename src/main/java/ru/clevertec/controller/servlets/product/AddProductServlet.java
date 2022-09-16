package ru.clevertec.controller.servlets.product;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import ru.clevertec.model.Product;
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
        Product product = new Product(name, price);
        productService.save(product);
        String json = new Gson().toJson(product);
        try (PrintWriter writer = resp.getWriter()) {
            writer.write(json);
            resp.setStatus(201);
        }
    }
}
