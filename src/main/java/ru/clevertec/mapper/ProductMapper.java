package ru.clevertec.mapper;

import org.springframework.stereotype.Component;
import ru.clevertec.dto.ProductDto;
import ru.clevertec.model.Product;

/**
 * Реализация интерфейса Mapper для Product.
 *
 * @author Lovtsov Aliaksei
 * @see Mapper
 */
@Component
public class ProductMapper implements Mapper<ProductDto, Product> {

    @Override
    public ProductDto toDto(Product entity) {
        return ProductDto.builder()
                .id(entity.getId())
                .name(entity.getProductName())
                .price(entity.getPrice())
                .build();
    }

    @Override
    public Product toEntity(ProductDto dto) {
        return Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .price(dto.getPrice())
                .build();
    }
}
