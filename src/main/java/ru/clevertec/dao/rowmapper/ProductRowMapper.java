package ru.clevertec.dao.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ru.clevertec.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Product.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("productName"))
                .price(rs.getDouble("price"))
                .build();
    }
}