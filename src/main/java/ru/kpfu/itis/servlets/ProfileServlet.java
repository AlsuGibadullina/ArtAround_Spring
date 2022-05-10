package ru.kpfu.itis.servlets;

import javax.servlet.http.HttpServlet;

//@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    /*
    private UsersService usersService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookies[] = req.getCookies();

        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("auth")) {
                User user = usersService.findUserByCookieValue(cookie.getValue());
                if (user != null) {
                    req.setAttribute("user", user);
                }
            }
        }
        req.getRequestDispatcher("jsp/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init() throws ServletException {
        try {
            //Подгружаем драйвер, оно автоматически регистрирует JDBC
            Class.forName("org.postgresql.Driver");
            String DB_URL = "jdbc:postgresql://localhost:5432/maven";
            String DB_USERNAME = "postgres";
            String DB_PASSWORD = "sadafa54ga";
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            UsersRepository usersRepository = new UsersRepositoryImpl(connection);
            AuthRepository authRepository = new AuthRepositoryImpl(connection);
            usersService = new UsersServiceImpl(usersRepository, authRepository);
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
