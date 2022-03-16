package ru.clevertec.service.impl;

import ru.clevertec.constants.Constants;
import ru.clevertec.exception.ParameterNotFoundException;
import ru.clevertec.data.DataReader;
import ru.clevertec.model.Product;
import ru.clevertec.service.ProductService;
import ru.clevertec.util.ParameterUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация интерфейса ProductService.
 *
 * @author Ловцов Алексей
 * @see ProductService
 */
public class ProductServiceImpl implements ProductService {

    /**
     * Считыватель данных.
     */
    private final DataReader dataReader;

    /**
     * Конструктор нового сервиса для товара, в который передается считыватель данных.
     *
     * @param dataReader считыватель данных
     */
    public ProductServiceImpl(DataReader dataReader) {
        this.dataReader = dataReader;
    }

    //------------------------------------------------------------------------------------------------

    @Override
    public Product findOneById(Integer id) {
        if (ParameterUtils.containsId(findAll(), id)) {
            for (Product product : findAll()) {
                if (product.getId().equals(id)) {
                    return product;
                }
            }
        }
        throw new ParameterNotFoundException("Присутствуют товары, отсутствующие в каталоге!");
    }

    @Override
    public List<Product> findAll() {
        List<String> lineList = dataReader.getProducts();
        if (!lineList.isEmpty()) {
            List<Product> productList = new ArrayList<>(lineList.size());
            for (String line : lineList) {
                String[] array = line.split(Constants.SEPARATOR);
                productList.add(
                        new Product(
                                Integer.parseInt(array[0]),         //id product
                                array[1],                           //name
                                Double.parseDouble(array[2])        //price
                        )
                );
            }
            return productList;
        }
        throw new ParameterNotFoundException("Ошибка чтения каталога товаров!");
    }
}
