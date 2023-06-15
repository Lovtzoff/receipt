package ru.clevertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.clevertec.model.DiscountCard;

/**
 * Интерфейс для работы с таблицей DiscountCard в БД.
 *
 * @author Lovtsov Aliaksei
 */
@Repository
public interface DiscountCardRepository extends JpaRepository<DiscountCard, Integer> {
}
