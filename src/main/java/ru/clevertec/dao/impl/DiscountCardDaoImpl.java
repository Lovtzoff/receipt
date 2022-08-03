package ru.clevertec.dao.impl;

import ru.clevertec.dao.DiscountCardDao;
import ru.clevertec.model.DiscountCard;
import ru.clevertec.util.DBConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DiscountCardDaoImpl implements DiscountCardDao {

    private static final String FIND_BY_ID = "SELECT * FROM DiscountCard WHERE id = ?";
    private static final String FIND_ALL = "SELECT * FROM DiscountCard";

    private final Connection connection = DBConnectionPool.INSTANCE.getConnection();

    @Override
    public Optional<DiscountCard> findById(Integer id) {
        Optional<DiscountCard> optionalDiscountCard = Optional.empty();
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                DiscountCard discountCard = new DiscountCard();
                discountCard.setId(resultSet.getInt("id"));
                discountCard.setDiscount(resultSet.getInt("discount"));
                optionalDiscountCard = Optional.of(discountCard);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return optionalDiscountCard;
    }

    @Override
    public List<DiscountCard> findAll() {
        try (PreparedStatement statement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            List<DiscountCard> discountCards = new ArrayList<>(resultSet.getFetchSize());
            while (resultSet.next()) {
                DiscountCard discountCard = new DiscountCard();
                discountCard.setId(resultSet.getInt("id"));
                discountCard.setDiscount(resultSet.getInt("discount"));
                discountCards.add(discountCard);
            }
            return discountCards;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
