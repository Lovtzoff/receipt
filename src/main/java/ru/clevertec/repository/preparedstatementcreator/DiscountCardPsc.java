package ru.clevertec.repository.preparedstatementcreator;

import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.SqlProvider;
import ru.clevertec.model.DiscountCard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Реализация PreparedStatementCreator для класса DiscountCard.
 *
 * @author Ловцов Алексей
 */
public class DiscountCardPsc implements PreparedStatementCreator, SqlProvider {

    /**
     * The Sql.
     */
    private final String sql;
    /**
     * The Discount card.
     */
    private final DiscountCard discountCard;

    /**
     * Конструктор.
     *
     * @param sql          the sql
     * @param discountCard the discount card
     */
    public DiscountCardPsc(String sql, DiscountCard discountCard) {
        super();
        this.sql = sql;
        this.discountCard = discountCard;
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
        ps.setInt(1, discountCard.getDiscount());
        return ps;
    }
}
