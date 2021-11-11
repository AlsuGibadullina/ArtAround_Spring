package ru.kpfu.itis.repositories;

import ru.kpfu.itis.models.Tag;
import ru.kpfu.itis.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TagsRepositoryImpl implements TagsRepository{

    private Connection connection;

    private final String SQL_FIND_TAG_BY_ID = "SELECT * FROM tags WHERE id=?";

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }


    @Override
    public Object save(Object o) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Tag findByTagId(Long id) {
        ResultSet resultSet = null;
        Tag tag = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_TAG_BY_ID);
            preparedStatement.setString(1, String.valueOf(id));

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                tag = new Tag();
                tag.setId(resultSet.getLong("id"));
                tag.setName(resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            //
        }
        return tag;
    }
}
