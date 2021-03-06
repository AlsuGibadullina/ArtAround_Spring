package ru.kpfu.itis.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.models.entities.Auth;
import ru.kpfu.itis.models.entities.User;

import java.sql.PreparedStatement;
import java.util.Optional;

@Repository
public class AuthRepositoryImpl implements AuthRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Auth> rowMapper = ((resultSet, rowNum) -> {
        return Auth.builder()
                .id(resultSet.getLong("auth_id"))
                .cookieValue(resultSet.getString("cookie_value"))
                .user(User.builder()
                        .id(resultSet.getLong("id"))
                        .nickname(resultSet.getString("nickname"))
                        .email(resultSet.getString("email"))
                        .passwordHash(resultSet.getString("passwordhash"))
                        .build())
                .build();
    });

    //language=sql
    private final String SQL_FIND_BY_COOKIE_VALUE = "SELECT  auth.id as auth_id, cookie_value, users.id as id, nickname,email,passwordhash FROM auth INNER JOIN users ON auth.user_id=users.id WHERE auth.cookie_value=?";
    private final String SQL_INSERT = "INSERT INTO auth (user_id, cookie_value) VALUES (?, ?)";
    private final String SQL_FIND_BY_ID = "SELECT auth.id as auth_id, cookie_value, users.id as id, username, email, passwordhash FROM auth INNER JOIN users ON auth.user_id=users.id WHERE auth.id=?";

    @Override
    public Optional<Auth> findByCookieValue(String cookieValue) {
        Auth auth;
        try {
            auth = jdbcTemplate.queryForObject(SQL_FIND_BY_COOKIE_VALUE, rowMapper, cookieValue);
        } catch (DataAccessException ex) {
            return Optional.empty();
        }
        System.out.println(auth);
        assert auth != null;
        return Optional.of(auth);
    }

    @Override
    public <S extends Auth> S save(S entity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, new String[]{"id"});

            statement.setLong(1, entity.getId());
            statement.setString(2, entity.getCookieValue());

            return statement;
        }, keyHolder);
        entity.setId(keyHolder.getKey().longValue());
        return entity;
    }

    @Override
    public <S extends Auth> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Auth> findById(Long aLong) {
        Auth auth;
        try {
            auth = jdbcTemplate.queryForObject(SQL_FIND_BY_ID, rowMapper, aLong);
        } catch (DataAccessException ex) {
            return Optional.empty();
        }
        return Optional.of(auth);
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Auth> findAll() {
        return null;
    }

    @Override
    public Iterable<Auth> findAllById(Iterable<Long> longs) {
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
    public void delete(Auth entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Auth> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
