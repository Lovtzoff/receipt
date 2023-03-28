package ru.clevertec.controller.initializer;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import ru.clevertec.config.ApplicationConfiguration;
import ru.clevertec.controller.servlets.discountcard.*;
import ru.clevertec.controller.servlets.product.*;
import ru.clevertec.controller.servlets.receipt.GetReceiptServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AnnotationWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(ApplicationConfiguration.class);
        context.refresh();

        // DiscountCard
        AddCardServlet addCardServlet = (AddCardServlet) context.getBean("addCardServlet");
        GetCardServlet getCardServlet = (GetCardServlet) context.getBean("getCardServlet");
        GetCardsServlet getCardsServlet = (GetCardsServlet) context.getBean("getCardsServlet");
        RemoveCardServlet removeCardServlet = (RemoveCardServlet) context.getBean("removeCardServlet");
        UpdateCardServlet updateCardServlet = (UpdateCardServlet) context.getBean("updateCardServlet");

        ServletRegistration.Dynamic addCard = servletContext.addServlet("addCardServlet", addCardServlet);
        ServletRegistration.Dynamic getCard = servletContext.addServlet("getCardServlet", getCardServlet);
        ServletRegistration.Dynamic getCards = servletContext.addServlet("getCardsServlet", getCardsServlet);
        ServletRegistration.Dynamic removeCard =
                servletContext.addServlet("removeCardServlet", removeCardServlet);
        ServletRegistration.Dynamic updateCard =
                servletContext.addServlet("updateCardServlet", updateCardServlet);

        addCard.addMapping("/api/card/add");
        getCard.addMapping("/api/card");
        getCards.addMapping("/api/cards");
        removeCard.addMapping("/api/card/remove");
        updateCard.addMapping("/api/card/update");

        // Product
        AddProductServlet addProductServlet = (AddProductServlet) context.getBean("addProductServlet");
        GetProductServlet getProductServlet = (GetProductServlet) context.getBean("getProductServlet");
        GetProductsServlet getProductsServlet = (GetProductsServlet) context.getBean("getProductsServlet");
        RemoveProductServlet removeProductServlet =
                (RemoveProductServlet) context.getBean("removeProductServlet");
        UpdateProductServlet updateProductServlet =
                (UpdateProductServlet) context.getBean("updateProductServlet");

        ServletRegistration.Dynamic addProduct =
                servletContext.addServlet("addProductServlet", addProductServlet);
        ServletRegistration.Dynamic getProduct =
                servletContext.addServlet("getProductServlet", getProductServlet);
        ServletRegistration.Dynamic getProducts =
                servletContext.addServlet("getProductsServlet", getProductsServlet);
        ServletRegistration.Dynamic removeProduct =
                servletContext.addServlet("removeProductServlet", removeProductServlet);
        ServletRegistration.Dynamic updateProduct =
                servletContext.addServlet("updateProductServlet", updateProductServlet);

        addProduct.addMapping("/api/product/add");
        getProduct.addMapping("/api/product");
        getProducts.addMapping("/api/products");
        removeProduct.addMapping("/api/product/remove");
        updateProduct.addMapping("/api/product/update");

        // Receipt
        GetReceiptServlet getReceiptServlet = (GetReceiptServlet) context.getBean("getReceiptServlet");

        ServletRegistration.Dynamic getReceipt =
                servletContext.addServlet("getReceiptServlet", getReceiptServlet);

        getReceipt.addMapping("/api/getReceipt");
    }
}
