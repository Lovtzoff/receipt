package ru.clevertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.clevertec.model.Product;

/**
 * Интерфейс для работы с таблицей Product в БД.
 *
 * @author Lovtsov Aliaksei
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
