package ru.clevertec.controller.initializer;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import ru.clevertec.config.ApplicationConfiguration;
import ru.clevertec.controller.servlets.discountcard.*;
import ru.clevertec.controller.servlets.product.*;
import ru.clevertec.controller.servlets.receipt.GetReceiptServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class AnnotationWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(ApplicationConfiguration.class);
        context.refresh();

        // DiscountCard
        AddCardServlet addCardServlet = context.getBean(AddCardServlet.class);
        GetCardServlet getCardServlet = context.getBean(GetCardServlet.class);
        GetCardsServlet getCardsServlet = context.getBean(GetCardsServlet.class);
        RemoveCardServlet removeCardServlet = context.getBean(RemoveCardServlet.class);
        UpdateCardServlet updateCardServlet = context.getBean(UpdateCardServlet.class);

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
        AddProductServlet addProductServlet = context.getBean(AddProductServlet.class);
        GetProductServlet getProductServlet = context.getBean(GetProductServlet.class);
        GetProductsServlet getProductsServlet = context.getBean(GetProductsServlet.class);
        RemoveProductServlet removeProductServlet = context.getBean(RemoveProductServlet.class);
        UpdateProductServlet updateProductServlet = context.getBean(UpdateProductServlet.class);

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
        GetReceiptServlet getReceiptServlet = context.getBean(GetReceiptServlet.class);

        ServletRegistration.Dynamic getReceipt =
                servletContext.addServlet("getReceiptServlet", getReceiptServlet);

        getReceipt.addMapping("/api/getReceipt");
    }
}
