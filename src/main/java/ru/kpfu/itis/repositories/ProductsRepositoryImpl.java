package ru.kpfu.itis.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.kpfu.itis.models.entities.Product;
import ru.kpfu.itis.models.entities.Status;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Optional;

public class ProductsRepositoryImpl implements ProductsRepository {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    private RowMapper<Product> rowMapper = ((resultSet, rowNum) -> {
        return Product.builder()
                .id(resultSet.getLong("id"))
                .title(resultSet.getString("title"))
                .description(resultSet.getString("description"))
                .photo(resultSet.getString("photo"))
                .cost(resultSet.getFloat("cost"))
                .status(Status.builder()
                        .id(resultSet.getLong("status_id"))
                        .name(resultSet.getString("name"))
                        .build())
                .tag(resultSet.getString("tag"))
                .build();
    });

    //language=sql
    private final String SQL_INSERT_PRODUCT = "INSERT INTO products (title, description, photo, cost, status_id, tag) values (?, ?, ?, ?, ?, ?)";
    private final String SQL_ADD_TO_FAVORITES = "INSERT INTO users_favorites (user_id, product_id) VALUES (?, ?)";
    private final String SQL_ADD_TO_PURCHASES = "INSERT INTO users_purchases(user_id, product_id) VALUES (?, ?)";
    private final String SQL_FIND_FAVORITES_BY_USER_ID = "SELECT * FROM products p INNER JOIN users_favorites f ON p.id = f.product_id INNER JOIN users ON f.user_id=users.id WHERE user_id=?;";
    private final String SQL_FIND_PURCHASES_BY_USER_ID = "SELECT * FROM products p INNER JOIN users_purchases ps ON p.id = ps.product_id INNER JOIN users ON ps.user_id=users.id WHERE user_id=?;";
    private final String SQL_FIND_ALL = "SELECT * FROM products;";
    private final String SQL_REMOVE_FROM_PURCHASES = "DELETE FROM users_purchases WHERE user_id = ? AND product_id = ?";
    private final String SQL_REMOVE_FROM_FAVORITES = "DELETE FROM users_favorites  WHERE user_id = ? AND product_id = ?";

    @Override
    public Optional<Object> findFavoritesByUserId(Long userId) {
        Product product;

        try {
            product = jdbcTemplate.queryForObject(SQL_FIND_FAVORITES_BY_USER_ID, rowMapper, userId);
        } catch (DataAccessException ex) {
            return Optional.empty();
        }
        System.out.println(product);
        assert product != null;
        return Optional.of(product);
    }

    @Override
    public Optional<Object> findPurchasesByUserId(Long userId) {
        Product product;

        try {
            product = jdbcTemplate.queryForObject(SQL_FIND_PURCHASES_BY_USER_ID, rowMapper, userId);
        } catch (DataAccessException ex) {
            return Optional.empty();
        }
        System.out.println(product);
        assert product != null;
        return Optional.of(product);
    }

    @Override
    public void addToPurchases(Long userId, Long productId) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(SQL_ADD_TO_PURCHASES, new String[]{"id"});

            statement.setLong(1, userId);
            statement.setLong(2, productId);

            return statement;
        }, keyHolder);
    }

    @Override
    public void addToFavorites(Long userId, Long productId) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(SQL_ADD_TO_FAVORITES, new String[]{"id"});

            statement.setLong(1, userId);
            statement.setLong(2, productId);

            return statement;
        }, keyHolder);
    }

    @Override
    public void removeFromPurchases(Long userId, Long productId) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(SQL_REMOVE_FROM_PURCHASES, new String[]{"id"});

            statement.setLong(1, userId);
            statement.setLong(2, productId);

            return statement;
        }, keyHolder);
    }

    @Override
    public void removeFromFavorites(Long userId, Long productId) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(SQL_REMOVE_FROM_FAVORITES, new String[]{"id"});

            statement.setLong(1, userId);
            statement.setLong(2, productId);

            return statement;
        }, keyHolder);
    }

    @Override
    public <S extends Product> S save(S entity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_PRODUCT, new String[]{"id"});

            statement.setString(1, entity.getTitle());
            statement.setString(2, entity.getDescription());
            statement.setString(3, entity.getPhoto());
            statement.setFloat(4, entity.getCost());
            statement.setLong(5, entity.getStatus().getId());
            statement.setString(6, entity.getTag());

            return statement;
        }, keyHolder);
        entity.setId(keyHolder.getKey().longValue());
        return entity;
    }

    @Override
    public <S extends Product> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Product> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Product> findAll() {
        Iterable<Product> products;
        try {
            products = jdbcTemplate.query(SQL_FIND_ALL, rowMapper);
        } catch (DataAccessException ex) {
            return new ArrayList<>();
        }
        return products;
    }

    @Override
    public Iterable<Product> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Product entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Product> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
