package ru.clevertec.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.dto.ProductDto;
import ru.clevertec.service.ProductService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts(@PathParam("size") String size,
                                                           @PathParam("page") String page) {
        return ResponseEntity.ok(productService.findAll(size, page));
    }

    @GetMapping("/product")
    public ResponseEntity<ProductDto> getProductById(@PathParam("id") Integer id) {
        return ResponseEntity.ok(productService.findOneById(id));
    }

    @PostMapping("/product/add")
    public ResponseEntity<ProductDto> addProduct(@PathParam("name") String name,
                                                 @PathParam("price") Double price) {
        ProductDto productDto = ProductDto.builder()
                .name(name)
                .price(price)
                .build();
        productDto = productService.save(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto);
    }

    @PutMapping("/product/update")
    public ResponseEntity<ProductDto> updateProductById(@PathParam("id") Integer id,
                                                        @PathParam("name") String name,
                                                        @PathParam("price") Double price) {
        ProductDto productDto = ProductDto.builder()
                .name(name)
                .price(price)
                .build();
        productDto = productService.update(productDto, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto);
    }

    @DeleteMapping("/product/remove")
    public ResponseEntity<Void> removeProductById(@PathParam("id") Integer id) {
        productService.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
