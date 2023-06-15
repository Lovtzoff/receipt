package ru.clevertec.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.dto.ProductDto;
import ru.clevertec.exception.ParameterNotFoundException;
import ru.clevertec.mapper.ProductMapper;
import ru.clevertec.model.Product;
import ru.clevertec.repository.ProductRepository;
import ru.clevertec.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

import static ru.clevertec.constants.Constants.DEFAULT_PAGE;
import static ru.clevertec.constants.Constants.DEFAULT_SIZE_PAGE;

/**
 * Реализация интерфейса ProductService.
 *
 * @author Ловцов Алексей
 * @see ProductService
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    /**
     * Получение данных из базы.
     */
    private final ProductRepository productRepository;
    /**
     * Конвертация сущности в DTO и обратно.
     */
    private final ProductMapper productMapper;

    @Override
    public ProductDto findOneById(Integer id) {
        return productRepository.findById(id)
                .map(productMapper::toDto)
                .orElseThrow(() -> new ParameterNotFoundException("Товар отсутствует в базе!"));
    }

    @Override
    public List<ProductDto> findAll(String size, String page) {
        int pageSize = (size != null) ? Integer.parseInt(size) : DEFAULT_SIZE_PAGE;
        int pageNumber = (page != null) ? (Integer.parseInt(page) * pageSize) : DEFAULT_PAGE;

        List<ProductDto> products = productRepository.findAll(PageRequest.of(pageNumber, pageSize))
                .stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
        if (!products.isEmpty()) {
            return products;
        } else {
            throw new ParameterNotFoundException("Ошибка чтения каталога товаров! База товаров пуста!");
        }
    }

    @Override
    @Transactional
    public ProductDto save(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    @Transactional
    public ProductDto update(ProductDto productDto, Integer id) {
        findOneById(id);
        Product product = productMapper.toEntity(productDto);
        product.setId(id);
        return productMapper.toDto(productRepository.saveAndFlush(product));
    }

    @Override
    @Transactional
    public void remove(Integer id) {
        findOneById(id);
        productRepository.deleteById(id);
    }
}
