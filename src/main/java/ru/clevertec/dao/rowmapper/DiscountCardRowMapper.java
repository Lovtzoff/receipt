package ru.clevertec.dao.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import ru.clevertec.model.DiscountCard;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiscountCardRowMapper implements RowMapper<DiscountCard> {

    @Override
    public DiscountCard mapRow(ResultSet rs, int rowNum) throws SQLException {
        return DiscountCard.builder()
                .id(rs.getInt("id"))
                .discount(rs.getInt("discount"))
                .build();
    }
}
