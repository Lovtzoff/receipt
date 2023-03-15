package ru.clevertec.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ru.clevertec.model.DiscountCard;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Трансляция записи из таблицы DiscountCard в java-класс DiscountCard.
 * Используется в {@link ru.clevertec.repository.impl.DiscountCardRepositoryImpl}
 *
 * @author Ловцов Алексей
 */
@Service
public class DiscountCardRowMapper implements RowMapper<DiscountCard> {

    /**
     * Возвращает информацию о дисконтной карте.
     *
     * @param rs     запись в таблице DiscountCard
     * @param rowNum номер записи
     * @return информация о дисконтной карте
     * @throws SQLException если в таблице нет колонки
     */
    @Override
    public DiscountCard mapRow(ResultSet rs, int rowNum) throws SQLException {
        return DiscountCard.builder()
                .id(rs.getInt("id"))
                .discount(rs.getInt("discount"))
                .build();
    }
}