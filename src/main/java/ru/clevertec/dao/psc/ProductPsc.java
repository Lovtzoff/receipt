package ru.clevertec.dao.psc;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.SqlProvider;
import ru.clevertec.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Реализация PreparedStatementCreator для класса Product.
 *
 * @author Ловцов Алексей
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductPsc implements PreparedStatementCreator, SqlProvider {

    /**
     * The Sql.
     */
    final String sql;
    /**
     * The Product.
     */
    final Product product;

    /**
     * Конструктор.
     *
     * @param sql     the sql
     * @param product the product
     */
    public ProductPsc(String sql, Product product) {
        super();
        this.sql = sql;
        this.product = product;
    }

    /**
     * Получить sql.
     *
     * @return the sql
     */
    @Override
    public String getSql() {
        return sql;
    }

    /**
     * Создать PreparedStatement с учетом соединения, предоставляемого классом JdbcTemplate.
     *
     * @param connection the connection
     * @return the prepared statement
     * @throws SQLException the sql exception
     */
    @Override
    @NotNull
    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(getSql(), new String[]{"id"});
        ps.setString(1, product.getName());
        ps.setDouble(2, product.getPrice());
        return ps;
    }
}
