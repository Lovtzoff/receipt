package ru.clevertec.repository.impl;

import lombok.RequiredArgsConstructor;
import org.intellij.lang.annotations.Language;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.clevertec.model.DiscountCard;
import ru.clevertec.repository.DiscountCardRepository;
import ru.clevertec.repository.rowmapper.DiscountCardRowMapper;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DiscountCardRepositoryImpl implements DiscountCardRepository {

    private final JdbcTemplate jdbcTemplate;
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
        // TODO: 15.03.2023 доделать
        return new DiscountCard();
    }

    @Override
    public Optional<DiscountCard> update(DiscountCard discountCard, Integer id) {
        // TODO: 15.03.2023 доделать
        return Optional.empty();
    }

    @Override
    public void delete(Integer id) {
        // TODO: 15.03.2023 доделать
    }
}
