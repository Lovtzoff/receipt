package ru.clevertec.dao;

import ru.clevertec.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {

    Optional<Product> findById(Integer id);

    List<Product> findAll();
}
