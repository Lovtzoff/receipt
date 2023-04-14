package ru.clevertec.dao.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ru.clevertec.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Трансляция записи из таблицы Product в java-класс Product.
 * Используется в {@link ru.clevertec.dao.impl.ProductDaoImpl}
 *
 * @author Ловцов Алексей
 */
@Service
public class ProductRowMapper implements RowMapper<Product> {

    /**
     * Возвращает информацию о товаре.
     *
     * @param rs     запись в таблице Product
     * @param rowNum номер записи
     * @return информация о товаре
     * @throws SQLException если в таблице нет колонки
     */
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Product.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("productName"))
                .price(rs.getDouble("price"))
                .build();
    }
}
