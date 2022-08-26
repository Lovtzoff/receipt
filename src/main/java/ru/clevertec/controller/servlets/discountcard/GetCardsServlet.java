package ru.clevertec.controller.servlets.discountcard;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import ru.clevertec.dao.impl.DiscountCardDaoImpl;
import ru.clevertec.model.DiscountCard;
import ru.clevertec.service.DiscountCardService;
import ru.clevertec.service.impl.DiscountCardServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/api/cards")
public class GetCardsServlet extends HttpServlet {

    private final DiscountCardService discountCardService = new DiscountCardServiceImpl(new DiscountCardDaoImpl());

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        List<DiscountCard> discountCards = discountCardService.findAll();
        String json = new Gson().toJson(discountCards);
        try (PrintWriter writer = resp.getWriter()) {
            writer.write(json);
            resp.setStatus(200);
        }
    }
}
