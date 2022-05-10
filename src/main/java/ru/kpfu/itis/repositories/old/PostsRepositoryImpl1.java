package ru.kpfu.itis.repositories.old;

public class PostsRepositoryImpl1{
    /*

    private final String FIND_ALL = "SELECT * FROM posts;";
    private Connection connection;
    private TagsRepository tagsRepository;

    public PostsRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List findAll() {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            resultSet = preparedStatement.executeQuery();
            List<Post> posts = rowMapPosts.rowMap(resultSet);
            return posts;
        } catch (SQLException e) {

        }
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

    private RowMapper<List<Post>> rowMapPosts = ((resultSet) -> {
        List<Post> posts = new ArrayList<>();
        while (resultSet.next()) {
            Post post = new Post();
            post.setId(resultSet.getLong("id"));
            post.setTitle(resultSet.getString("title"));
            post.setText(resultSet.getString("text"));
            post.setPhoto(resultSet.getString("photo"));
            post.setTag(resultSet.getString("tag"));
            posts.add(post);
        }
        return posts;
    });

     */
}
