package ru.kpfu.itis.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.kpfu.itis.models.entities.Post;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Optional;

public class PostsRepositoryImpl implements PostsRepository {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    private RowMapper<Post> rowMapper = ((resultSet, rowNum) -> {
        return Post.builder()
                .id(resultSet.getLong("id"))
                .title(resultSet.getString("title"))
                .text(resultSet.getString("photo"))
                .tag(resultSet.getString("tag"))
                .build();
    });

    //language=sql
    private final String SQL_INSERT_POST = "INSERT INTO posts (title, text, photo, tag) VALUE ?, ?, ?, ?";
    private final String SQL_FIND_ALL = "SELECT * FROM posts";

    @Override
    public <S extends Post> S save(S entity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_POST, new String[]{"id"});

            statement.setString(1, entity.getTitle());
            statement.setString(2, entity.getText());
            statement.setString(3, entity.getPhoto());
            statement.setString(4, entity.getTag());

            return statement;
        }, keyHolder);
        entity.setId(keyHolder.getKey().longValue());
        return entity;
    }

    @Override
    public <S extends Post> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Post> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Post> findAll() {
        Iterable<Post> posts;
        try {
            posts = jdbcTemplate.query(SQL_FIND_ALL, rowMapper);
        } catch (DataAccessException ex) {
            return new ArrayList<>();
        }
        return posts;
    }

    @Override
    public Iterable findAllById(Iterable iterable) {
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
    public void delete(Post entity) {

    }

    @Override
    public void deleteAllById(Iterable iterable) {

    }

    @Override
    public void deleteAll(Iterable entities) {

    }

    @Override
    public void deleteAll() {

    }
}
