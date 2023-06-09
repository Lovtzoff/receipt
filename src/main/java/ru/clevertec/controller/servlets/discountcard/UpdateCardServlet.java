package ru.clevertec.controller.servlets.discountcard;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import ru.clevertec.dto.DiscountCardDto;
import ru.clevertec.service.DiscountCardService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
@RequiredArgsConstructor
public class UpdateCardServlet extends HttpServlet {

    private final DiscountCardService discountCardService;

    @SneakyThrows
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        Integer id = Integer.valueOf(req.getParameter("id"));
        Integer discount = Integer.valueOf(req.getParameter("discount"));
        DiscountCardDto discountCardDto = DiscountCardDto.builder()
                .discount(discount)
                .build();
        discountCardDto = discountCardService.update(discountCardDto, id);
        String json = new Gson().toJson(discountCardDto);
        try (PrintWriter writer = resp.getWriter()) {
            writer.write(json);
            resp.setStatus(201);
        }
    }
}
