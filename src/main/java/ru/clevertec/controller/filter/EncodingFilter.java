package ru.clevertec.controller.filter;

import lombok.SneakyThrows;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class EncodingFilter implements Filter {

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestUrl = httpRequest.getRequestURI();

        if (!requestUrl.startsWith("/api/getReceipt")) {
            // Выполняем фильтрацию для всех шаблонов URL, кроме "/api/getReceipt"
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            chain.doFilter(request, response);
        } else {
            // Пропустить фильтрацию для "/api/getReceipt"
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            chain.doFilter(request, response);
        }
    }
}
