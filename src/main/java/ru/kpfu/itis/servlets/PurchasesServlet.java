package ru.kpfu.itis.servlets;

import javax.servlet.http.HttpServlet;

//@WebServlet("/purchases")
public class PurchasesServlet extends HttpServlet {
    /*
    private UsersService usersService;
    private ProductsService productsService;

    private final String DB_URL = "jdbc:postgresql://localhost:5432/maven";
    private final String DB_USERNAME = "postgres";
    private final String DB_PASSWORD = "sadafa54ga";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Cookie cookie = CookieService.getCookie(req, "auth");
        if (cookie != null) {
            User user = usersService.findUserByCookieValue(cookie.getValue());
            if (user != null) {
                List<Product> products = productsService.findPurchasesByUserId(user.getId());
                req.setAttribute("products", products);
                req.getRequestDispatcher("/jsp/purchases.jsp").forward(req, resp);
            }
        } else {
            resp.sendRedirect("/signIn");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = CookieService.getCookie(req, "auth");
        if (cookie != null) {
            User user = usersService.findUserByCookieValue(cookie.getValue());
            if (user != null) {
                String idToRemove = req.getParameter("idToRemove");
                if (idToRemove != null) {
                    productsService.removeFromPurchases(user.getId(), Long.valueOf(idToRemove));
                    req.getRequestDispatcher("/jsp/products.jsp").forward(req, resp);
                }
            }
        }
    }

    @Override
    public void init() throws ServletException {
        try {
            //Подгружаем драйвер, оно автоматически регистрирует JDBC
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            UsersRepository usersRepository = new UsersRepositoryImpl1(connection);
            AuthRepository authRepository = new AuthRepositoryImpl1(connection);
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

     */
}
