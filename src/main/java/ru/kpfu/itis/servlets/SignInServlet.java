package ru.kpfu.itis.servlets;

import ru.kpfu.itis.form.LoginForm;
import ru.kpfu.itis.repositories.AuthRepository;
import ru.kpfu.itis.repositories.AuthRepositoryImpl;
import ru.kpfu.itis.repositories.UsersRepository;
import ru.kpfu.itis.repositories.UsersRepositoryImpl;
import ru.kpfu.itis.services.UsersService;
import ru.kpfu.itis.services.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {

    private UsersService usersService;

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
            usersService = new UsersServiceImpl(usersRepository);
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
        req.getRequestDispatcher("jsp/signIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nickname = request.getParameter("nickname");
        String password = request.getParameter("password");

        LoginForm loginForm = new LoginForm(nickname, password);
        Cookie cookie = usersService.signIn(loginForm);

        if (cookie != null) {
            response.addCookie(cookie);
            response.addCookie(new Cookie("nickname", nickname));

            response.sendRedirect("home");
        } else {
            request.setAttribute("signInStatus", "Неправильный никнейм пользователя или пароль");
            request.getRequestDispatcher("jsp/signIn.jsp").forward(request, response);
        }
    }
}
