package ru.kpfu.itis.repositories.old;

import ru.kpfu.itis.mapper.RowMapper;

public class AuthRepositoryImpl1{

    /*private Connection connection;

    private final String SQL_FIND_BY_COOKIE_VALUE = "SELECT auth_id, user_id, cookie_value, nickname, email, passwordhash FROM auth INNER JOIN users ON auth.user_id=users.id WHERE auth.cookie_value=?";
    private final String SQL_INSERT_AUTH = "INSERT INTO auth (user_id, cookie_value) VALUES (?, ?)";

    public AuthRepositoryImpl1(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Auth findByCookieValue(String cookieValue) {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_COOKIE_VALUE);
            preparedStatement.setString(1, cookieValue);
            resultSet = preparedStatement.executeQuery();
            Auth auth = authRowMapper.rowMap(resultSet);
            System.out.println("A" + auth);
            return auth;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Auth> findAll() {
        return null;
    }

    @Override
    public Optional<Auth> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Auth save(Auth auth) {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_AUTH, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, auth.getUser().getId());
            preparedStatement.setString(2, auth.getCookieValue());
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {

        }
        return auth;
    }

    @Override
    public void deleteById(Long id) {

    }

    private RowMapper<Auth> authRowMapper = (resultSet) -> {
        if (resultSet.next()) {
            Auth auth = new Auth();
            auth.setId(resultSet.getLong("auth_id"));
            auth.setCookieValue(resultSet.getString("cookie_value"));

            User user = new User();
            user.setId(resultSet.getLong("user_id"));
            user.setNickname(resultSet.getString("nickname"));
            user.setEmail(resultSet.getString("email"));
            user.setPasswordHash(resultSet.getString("passwordhash"));

            auth.setUser(user);
            return auth;
        } else {
            return null;
        }
    };

     */
}
