package ru.clevertec.controller.servlets.discountcard;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import ru.clevertec.dto.DiscountCardDto;
import ru.clevertec.exception.ParameterNotFoundException;
import ru.clevertec.service.DiscountCardService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
@RequiredArgsConstructor
public class GetCardServlet extends HttpServlet {

    private final DiscountCardService discountCardService;

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Integer id = Integer.valueOf(req.getParameter("id"));
        try {
            DiscountCardDto discountCardDto = discountCardService.findOneById(id);
            String json = new Gson().toJson(discountCardDto);
            try (PrintWriter writer = resp.getWriter()) {
                writer.write(json);
                resp.setStatus(200);
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
