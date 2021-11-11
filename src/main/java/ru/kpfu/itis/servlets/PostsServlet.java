package ru.kpfu.itis.servlets;

import ru.kpfu.itis.models.Post;
import ru.kpfu.itis.repositories.*;
import ru.kpfu.itis.services.PostsService;
import ru.kpfu.itis.services.PostsServiceImpl;
import ru.kpfu.itis.services.UsersService;
import ru.kpfu.itis.services.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/home")
public class PostsServlet extends HttpServlet {

    private UsersService usersService;
    private PostsService postsService;

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
            PostsRepository postsRepository = new PostsRepositoryImpl(connection);
            postsService = new PostsServiceImpl(postsRepository);
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

        List<Post> posts = postsService.findAll();
        req.setAttribute("posts", posts);
        req.getRequestDispatcher("/jsp/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
