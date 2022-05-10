package ru.kpfu.itis.servlets;

import javax.servlet.http.HttpServlet;

//@WebServlet("/products")
public class ProductsServlet extends HttpServlet {
    /*
    private UsersService usersService;
    private ProductsService productsService;

    private final String DB_URL = "jdbc:postgresql://localhost:5432/maven";
    private final String DB_USERNAME = "postgres";
    private final String DB_PASSWORD = "sadafa54ga";

    @Override
    public void init() throws ServletException {
        try {
            //Подгружаем драйвер, оно автоматически регистрирует JDBC
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            UsersRepository usersRepository = new UsersRepositoryImpl(connection);
            AuthRepository authRepository = new AuthRepositoryImpl(connection);
            usersService = new UsersServiceImpl(usersRepository, authRepository);
            ProductsRepository productsRepository = new ProductsRepositoryImpl1(connection);
            productsService = new ProductsServiceImpl(productsRepository);
        } catch (SQLException e) {
            System.out.println("Unavailable");
            throw new UnavailableException("Сайт недоступен!!!");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            throw new UnavailableException("Сайт недоступен!!!");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        List<Product> products = productsService.findAll();
        System.out.println(products);
        req.setAttribute("products", products);
        req.getRequestDispatcher("/jsp/products.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Cookie cookie = CookieService.getCookie(req, "auth");
        if (cookie != null) {
            User user = usersService.findUserByCookieValue(cookie.getValue());
            if (user != null) {
                String addToPurchasesId = req.getParameter("to_purchases");
                if (addToPurchasesId != null) {
                    productsService.addToPurchases(user.getId(), Long.valueOf(addToPurchasesId));
                    req.getRequestDispatcher("/jsp/products.jsp").forward(req, resp);
                }

                String addToFavoriteId = req.getParameter("to_favorite");
                if (addToFavoriteId != null) {
                    productsService.addToFavorites(user.getId(), Long.valueOf(addToFavoriteId));
                    req.getRequestDispatcher("/jsp/products.jsp").forward(req, resp);
                }
            }
        }

        req.getRequestDispatcher("/jsp/products.jsp").forward(req, resp);
    }

     */
}
