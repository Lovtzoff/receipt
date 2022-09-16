package ru.clevertec.controller.servlets.discountcard;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import ru.clevertec.model.DiscountCard;
import ru.clevertec.service.DiscountCardService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
@RequiredArgsConstructor
public class AddCardServlet extends HttpServlet {

    private final DiscountCardService discountCardService;

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        Integer discount = Integer.valueOf(req.getParameter("discount"));
        DiscountCard discountCard = new DiscountCard(discount);
        discountCardService.save(discountCard);
        String json = new Gson().toJson(discountCard);
        try (PrintWriter writer = resp.getWriter()) {
            writer.write(json);
            resp.setStatus(201);
        }
    }
}
