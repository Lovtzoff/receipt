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
import java.util.List;

@Component
@RequiredArgsConstructor
public class GetProductsServlet extends HttpServlet {

    private final ProductService productService;

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String size = req.getParameter("size");
        String page = req.getParameter("page");
        List<Product> products = productService.findAll(size, page);
        String json = new Gson().toJson(products);
        try (PrintWriter writer = resp.getWriter()) {
            writer.write(json);
            resp.setStatus(200);
        }
    }
}
