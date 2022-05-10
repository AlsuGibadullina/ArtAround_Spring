package ru.kpfu.itis.servlets;

import javax.servlet.http.HttpServlet;

//@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
/*
    private UsersService usersService;

    private final String DB_URL = "jdbc:postgresql://localhost:5432/maven";
    private final String DB_USERNAME = "postgres";
    private final String DB_PASSWORD = "sadafa54ga";

    @Override
    public void init() throws ServletException {
        try {
            //Подгружаем драйвер, оно автоматически регистрирует JDBC
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            UsersRepository usersRepository = new UsersRepositoryImpl1(connection);
            AuthRepository authRepository = new AuthRepositoryImpl1(connection);
            usersService = new UsersServiceImpl(usersRepository, authRepository);
        } catch (SQLException e) {
            System.out.println("Unavailable");
            throw new UnavailableException("Сайт недоступен!!!");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            throw new UnavailableException("Сайт недоступен!!!");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/signIn.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        LoginForm loginForm = new LoginForm(email, password);
        Cookie cookie = usersService.signIn(loginForm);

        if (cookie != null) {
            response.addCookie(cookie);
            response.sendRedirect("/home");
        } else {
            request.setAttribute("signInStatus", "Неправильная почта или пароль");
            request.getRequestDispatcher("jsp/signIn.jsp").forward(request, response);
        }
    }

 */
}
