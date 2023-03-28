package ru.clevertec.dao.impl;

import lombok.RequiredArgsConstructor;
import org.intellij.lang.annotations.Language;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.clevertec.dao.ProductDao;
import ru.clevertec.dao.psc.ProductPsc;
import ru.clevertec.dao.rowmapper.ProductRowMapper;
import ru.clevertec.model.Product;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductDaoImpl implements ProductDao {

    private final JdbcTemplate jdbcTemplate;
    private final ProductRowMapper productRowMapper;

    @Language("SQL")
    private static final String FIND_BY_ID = "SELECT * FROM product WHERE id = ?";
    @Language("SQL")
    private static final String FIND_ALL = "SELECT * FROM product LIMIT (?) OFFSET (?)";
    @Language("SQL")
    private static final String ADD_PRODUCT = "INSERT INTO product (productName, price) VALUES (?, ?)";
    @Language("SQL")
    private static final String UPDATE_PRODUCT = "UPDATE product SET productName = ?, price = ? WHERE id = ?";
    @Language("SQL")
    private static final String DELETE_PRODUCT_BY_ID = "DELETE FROM product WHERE id = ?";

    @Override
    public Optional<Product> findById(Integer id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID, productRowMapper, id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Product> findAll(Integer size, Integer page) {
        return jdbcTemplate.query(FIND_ALL, productRowMapper, size, page);
    }

    @Override
    public Product add(Product product) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new ProductPsc(ADD_PRODUCT, product), keyHolder);
        product.setId(Objects.requireNonNull(keyHolder.getKey()).intValue());
        return product;
    }

    @Override
    public Optional<Product> update(Product product, Integer id) {
        jdbcTemplate.update(UPDATE_PRODUCT, product.getName(), product.getPrice(), id);
        product.setId(id);
        return Optional.of(product);
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update(DELETE_PRODUCT_BY_ID, id);
    }
}
