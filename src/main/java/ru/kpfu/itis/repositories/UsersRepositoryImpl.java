package ru.kpfu.itis.repositories;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.kpfu.itis.models.entities.User;

import java.sql.PreparedStatement;
import java.util.Optional;

public class UsersRepositoryImpl implements UsersRepository {

    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> userRowMapper = ((resultSet, rowNum) -> {
        return User.builder()
                .id(resultSet.getLong("id"))
                .nickname(resultSet.getString("nickname"))
                .email(resultSet.getString("email"))
                .passwordHash(resultSet.getString("passwordHash"))
                .build();
    });

    //language=sql
    private final String SQL_INSERT = "INSERT INTO users(nickname, email, passwordhash) VALUES (?, ?, ?)";
    private final String SQL_FIND_USER_BY_ID = "SELECT * FROM users WHERE id=?;";
    private final String SQL_FIND_USER_BY_EMAIL = "SELECT * FROM users WHERE email=?;";

    public UsersRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public <S extends User> S save(S user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, new String[]{"id"});
            statement.setString(1, user.getNickname());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPasswordHash());

            return statement;
        }, keyHolder);

        user.setId(keyHolder.getKey().longValue());
         return user;
    }

    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        User user;
        try {
            user = jdbcTemplate.queryForObject(SQL_FIND_USER_BY_ID, userRowMapper, id);
        } catch (DataAccessException ex) {
            return Optional.empty();
        }
        return Optional.of(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        User user;
        try {
            user = jdbcTemplate.queryForObject(SQL_FIND_USER_BY_EMAIL, userRowMapper, email);
        }catch (DataAccessException ex){
            return Optional.empty();
        }
        return Optional.of(user);
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public Iterable<User> findAllById(Iterable<Long> longs) {
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
    public void delete(User entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends User> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
