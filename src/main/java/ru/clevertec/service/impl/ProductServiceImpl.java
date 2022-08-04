package ru.clevertec.service.impl;

import ru.clevertec.dao.ProductDao;
import ru.clevertec.exception.ParameterNotFoundException;
import ru.clevertec.model.Product;
import ru.clevertec.service.ProductService;
import ru.clevertec.util.ParameterUtils;

import java.util.List;
import java.util.Optional;

/**
 * Реализация интерфейса ProductService.
 *
 * @author Ловцов Алексей
 * @see ProductService
 */
public class ProductServiceImpl implements ProductService {

    /**
     * Получение данных из базы.
     */
    private final ProductDao productDao;

    /**
     * Конструктор нового сервиса для товара, в который передаются данные из базы.
     *
     * @param productDao считыватель данных
     */
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    //------------------------------------------------------------------------------------------------

    @Override
    public Product findOneById(Integer id) {
        Optional<Product> optionalProduct = productDao.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        throw new ParameterNotFoundException("Присутствуют товары, отсутствующие в каталоге!");
    }

    @Override
    public List<Product> findAll() {
//        List<String> lineList = dataReader.getProducts();
//        if (!lineList.isEmpty()) {
//            List<Product> productList = new ArrayList<>(lineList.size());
//            lineList.stream()
//                    .map(line -> line.split(Constants.SEPARATOR))
//                    .forEach(array -> productList.add(
//                            new Product(
//                                    Integer.parseInt(array[0]),         //id product
//                                    array[1],                           //name
//                                    Double.parseDouble(array[2])        //price
//                            )));
//            return productList;
//        }
        throw new ParameterNotFoundException("Ошибка чтения каталога товаров!");
    }
}
