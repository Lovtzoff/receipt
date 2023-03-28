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

@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductPsc implements PreparedStatementCreator, SqlProvider {

    final String sql;
    final Product product;

    public ProductPsc(String sql, Product product) {
        super();
        this.sql = sql;
        this.product = product;
    }

    @Override
    public String getSql() {
        return sql;
    }

    @Override
    @NotNull
    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(getSql(), new String[]{"id"});
        ps.setString(1, product.getName());
        ps.setDouble(2, product.getPrice());
        return ps;
    }
}
