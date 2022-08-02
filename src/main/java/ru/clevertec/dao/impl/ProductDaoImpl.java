package ru.clevertec.dao.impl;

import ru.clevertec.dao.ProductDao;
import ru.clevertec.model.Product;
import ru.clevertec.util.DBConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductDaoImpl implements ProductDao {

    private static final String FIND_BY_ID = "SELECT * FROM product WHERE id = ?";

    @Override
    public Optional<Product> findById(Integer id) {
        Optional<Product> optionalProduct = Optional.empty();
        try (Connection connection = DBConnectionPool.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("productName"));
                product.setPrice(resultSet.getDouble("price"));
                optionalProduct = Optional.of(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return optionalProduct;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}
