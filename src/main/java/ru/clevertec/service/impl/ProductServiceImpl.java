package ru.clevertec.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.clevertec.repository.ProductDaoRepository;
import ru.clevertec.exception.ParameterNotFoundException;
import ru.clevertec.model.Product;
import ru.clevertec.service.ProductService;

import java.util.List;
import java.util.Optional;

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
    private final ProductDaoRepository productDaoRepository;

    @Override
    public Product findOneById(Integer id) {
        Optional<Product> optionalProduct = productDaoRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        throw new ParameterNotFoundException("Присутствуют товары, отсутствующие в каталоге!");
    }

    @Override
    public List<Product> findAll(String size, String page) {
        int pageSize = (size != null) ? Integer.parseInt(size) : DEFAULT_SIZE_PAGE;
        int pageNumber = (page != null) ? (Integer.parseInt(page) * pageSize) : DEFAULT_PAGE;

        List<Product> products = productDaoRepository.findAll(pageSize, pageNumber);
        if (!products.isEmpty()) {
            return products;
        }
        throw new ParameterNotFoundException("Ошибка чтения каталога товаров! База товаров пуста!");
    }

    @Override
    public Product save(Product product) {
        return productDaoRepository.add(product);
    }

    @Override
    public Product update(Product product, Integer id) {
        Optional<Product> optionalProduct = productDaoRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return productDaoRepository.update(product, id).get();
        }
        throw new ParameterNotFoundException("Товар отсутствует в базе!");
    }

    @Override
    public void remove(Integer id) {
        productDaoRepository.delete(id);
    }
}
