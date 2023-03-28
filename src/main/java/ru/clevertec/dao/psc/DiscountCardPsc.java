package ru.clevertec.dao.psc;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.SqlProvider;
import ru.clevertec.model.DiscountCard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscountCardPsc implements PreparedStatementCreator, SqlProvider {

    final String sql;
    final DiscountCard discountCard;

    public DiscountCardPsc(String sql, DiscountCard discountCard) {
        super();
        this.sql = sql;
        this.discountCard = discountCard;
    }

    @Override
    public String getSql() {
        return sql;
    }

    @Override
    @NotNull
    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(getSql(), new String[]{"id"});
        ps.setInt(1, discountCard.getDiscount());
        return ps;
    }
}
