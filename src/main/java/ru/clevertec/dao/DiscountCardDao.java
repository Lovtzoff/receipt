package ru.clevertec.dao;

import ru.clevertec.model.DiscountCard;

import java.util.List;
import java.util.Optional;

public interface DiscountCardDao {

    Optional<DiscountCard> findById(Integer id);

    List<DiscountCard> findAll(Integer size, Integer page);

    DiscountCard add(DiscountCard discountCard);

    Optional<DiscountCard> update(DiscountCard discountCard, Integer id);

    void delete(Integer id);
}
