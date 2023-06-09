package ru.clevertec.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.clevertec.dao.ProductDao;
import ru.clevertec.dto.ProductDto;
import ru.clevertec.exception.ParameterNotFoundException;
import ru.clevertec.mapper.ProductMapper;
import ru.clevertec.model.Product;
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
public class ProductServiceImpl implements ProductService {

    /**
     * Получение данных из базы.
     */
    private final ProductDao productDao;
    /**
     * Конвертация сущности в DTO и обратно.
     */
    private final ProductMapper productMapper;

    @Override
    public ProductDto findOneById(Integer id) {
        return productDao.findById(id)
                .map(productMapper::toDto)
                .orElseThrow(() -> new ParameterNotFoundException("Товар отсутствует в базе!"));
    }

    @Override
    public List<ProductDto> findAll(String size, String page) {
        int pageSize = (size != null) ? Integer.parseInt(size) : DEFAULT_SIZE_PAGE;
        int pageNumber = (page != null) ? (Integer.parseInt(page) * pageSize) : DEFAULT_PAGE;

        List<ProductDto> products = productDao.findAll(pageSize, pageNumber).stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
        if (!products.isEmpty()) {
            return products;
        } else {
            throw new ParameterNotFoundException("Ошибка чтения каталога товаров! База товаров пуста!");
        }
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        return productMapper.toDto(productDao.add(product));
    }

    @Override
    public ProductDto update(ProductDto productDto, Integer id) {
        findOneById(id);
        Product product = productMapper.toEntity(productDto);
        return productMapper.toDto(productDao.update(product, id).get());
    }

    @Override
    public void remove(Integer id) {
        findOneById(id);
        productDao.delete(id);
    }
}
