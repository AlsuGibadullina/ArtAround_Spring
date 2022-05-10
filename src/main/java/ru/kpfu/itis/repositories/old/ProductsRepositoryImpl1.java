package ru.kpfu.itis.repositories.old;

import ru.kpfu.itis.mapper.RowMapper;

public class ProductsRepositoryImpl1{
    /*

    private Connection connection;
    private TagsRepository tagsRepository;

    //language=sql
    private final String ADD_TO_FAVORITES = "INSERT INTO users_favorites (user_id, product_id) VALUES (?, ?)";
    private final String ADD_TO_PURCHASES = "INSERT INTO users_purchases(user_id, product_id) VALUES (?, ?)";
    private final String FIND_FAVORITES_BY_USER_ID = "SELECT * FROM products p INNER JOIN users_favorites f ON p.id = f.product_id INNER JOIN users ON f.user_id=users.id WHERE user_id=?;";
    private final String FIND_PURCHASES_BY_USER_ID = "SELECT * FROM products p INNER JOIN users_purchases ps ON p.id = ps.product_id INNER JOIN users ON ps.user_id=users.id WHERE user_id=?;";
    private final String FIND_ALL = "SELECT * FROM products;";
    private final String REMOVE_FROM_PURCHASES = "DELETE FROM users_purchases WHERE user_id = ? AND product_id = ?";
    private final String REMOVE_FROM_FAVORITES = "DELETE FROM users_favorites  WHERE user_id = ? AND product_id = ?";

    public ProductsRepositoryImpl1(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Product> findAll() {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            resultSet = preparedStatement.executeQuery();
            List<Product> products = rowMapProducts.rowMap(resultSet);
            return products;
        } catch (SQLException e) {

        }
        return null;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Product save(Product product) {
        return null;
    }



    @Override
    public void deleteById(Long id) {

    }

    private RowMapper<Product> rowMapper = ((resultSet) -> {
        if (resultSet.next()) {
            Product product = new Product();
            product.setId(resultSet.getLong("id"));
            product.setTitle(resultSet.getString("title"));
            product.setCost(resultSet.getFloat("cost"));
            product.setDescription(resultSet.getString("description"));
            product.setPhoto(resultSet.getString("photo"));
            product.setTag(resultSet.getString("tag"));

            return product;
        } else {
            return null;
        }
    });

    @Override
    public List<Product> findFavoritesByUserId(Long userId) {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_FAVORITES_BY_USER_ID);
            preparedStatement.setLong(1, userId);
            resultSet = preparedStatement.executeQuery();
            List<Product> products = rowMapProducts.rowMap(resultSet);
            return products;
        } catch (SQLException e) {

        }
        return null;
    }

    @Override
    public List<Product> findPurchasesByUserId(Long userId) {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_PURCHASES_BY_USER_ID);
            preparedStatement.setLong(1, userId);
            resultSet = preparedStatement.executeQuery();
            List<Product> products = rowMapProducts.rowMap(resultSet);
            return products;
        } catch (SQLException e) {

        }
        return null;
    }

    @Override
    public void addToPurchases(Long userId, Long productId) {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_TO_PURCHASES, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, userId);
            preparedStatement.setLong(2, productId);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {

        }
    }

    @Override
    public void addToFavorites(Long userId, Long productId) {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_TO_FAVORITES, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, userId);
            preparedStatement.setLong(2, productId);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {

        }
    }

    private RowMapper<List<Product>> rowMapProducts = ((resultSet) -> {
        List<Product> products = new ArrayList<>();
        while (resultSet.next()) {
            Product product = new Product();
            product.setId(resultSet.getLong("id"));
            product.setTitle(resultSet.getString("title"));
            product.setCost(resultSet.getFloat("cost"));
            product.setDescription(resultSet.getString("description"));
            product.setPhoto(resultSet.getString("photo"));
            product.setTag(resultSet.getString("tag"));
            products.add(product);
        }
        return products;
    });

    @Override
    public void removeFromPurchases(Long userId, Long productId) {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_FROM_PURCHASES, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, userId);
            preparedStatement.setLong(2, productId);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {

        }
    }

    @Override
    public void removeFromFavorites(Long userId, Long productId) {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_FROM_FAVORITES, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, userId);
            preparedStatement.setLong(2, productId);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {

        }
    }

     */
}