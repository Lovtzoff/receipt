package ru.clevertec.repository.impl;

import lombok.RequiredArgsConstructor;
import org.intellij.lang.annotations.Language;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.clevertec.model.DiscountCard;
import ru.clevertec.repository.DiscountCardRepository;
import ru.clevertec.repository.preparedstatementcreator.DiscountCardPsc;
import ru.clevertec.repository.rowmapper.DiscountCardRowMapper;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Реализация интерфейса DiscountCardRepository: отправка запросов к БД.
 *
 * @author Ловцов Алексей
 * @see DiscountCardRepository
 */
@Repository
@RequiredArgsConstructor
public class DiscountCardRepositoryImpl implements DiscountCardRepository {

    /**
     * Объект для отправки SQL-запросов к БД.
     */
    private final JdbcTemplate jdbcTemplate;
    /**
     * Объект для преобразования записи из таблицы БД в класс DiscountCard.
     */
    private final DiscountCardRowMapper discountCardRowMapper;

    @Language("SQL")
    private static final String FIND_BY_ID = "SELECT * FROM DiscountCard WHERE id = ?";
    @Language("SQL")
    private static final String FIND_ALL = "SELECT * FROM DiscountCard LIMIT (?) OFFSET (?)";
    @Language("SQL")
    private static final String ADD_DISCOUNT_CARD = "INSERT INTO DiscountCard (discount) VALUES (?)";
    @Language("SQL")
    private static final String UPDATE_DISCOUNT_CARD = "UPDATE DiscountCard SET discount = ? WHERE id = ?";
    @Language("SQL")
    private static final String DELETE_DISCOUNT_CARD_BY_ID = "DELETE FROM DiscountCard WHERE id = ?";

    @Override
    public Optional<DiscountCard> findById(Integer id) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(FIND_BY_ID, discountCardRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<DiscountCard> findAll(Integer size, Integer page) {
        return jdbcTemplate.query(FIND_ALL, discountCardRowMapper, size, page);
    }

    @Override
    public DiscountCard add(DiscountCard discountCard) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new DiscountCardPsc(ADD_DISCOUNT_CARD, discountCard), keyHolder);
        discountCard.setId(Objects.requireNonNull(keyHolder.getKey()).intValue());
        return discountCard;
    }

    @Override
    public Optional<DiscountCard> update(DiscountCard discountCard, Integer id) {
        jdbcTemplate.update(UPDATE_DISCOUNT_CARD, discountCard.getDiscount(), id);
        discountCard.setId(id);
        return Optional.of(discountCard);
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update(DELETE_DISCOUNT_CARD_BY_ID, id);
    }
}
