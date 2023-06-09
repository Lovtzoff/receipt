package ru.clevertec.controller.servlets.discountcard;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import ru.clevertec.exception.ParameterNotFoundException;
import ru.clevertec.service.DiscountCardService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
@RequiredArgsConstructor
public class RemoveCardServlet extends HttpServlet {

    private final DiscountCardService discountCardService;

    @SneakyThrows
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        Integer id = Integer.valueOf(req.getParameter("id"));
        try {
            discountCardService.remove(id);
            resp.setStatus(204); // No content
        } catch (ParameterNotFoundException ex) {
            String json = new Gson().toJson("Message: " + ex.getMessage());
            try (PrintWriter writer = resp.getWriter()) {
                writer.write(json);
                resp.setStatus(404);
            }
        }
    }
}
