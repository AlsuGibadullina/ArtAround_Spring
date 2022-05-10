package ru.kpfu.itis.servlets;

import javax.servlet.http.HttpServlet;

//@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
/*
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

            UsersRepository usersRepository = new UsersRepositoryImpl1(connection);
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String nickname = request.getParameter("nickname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String status = "";
        if (nickname.length() < 3) {
            status = "Длина никнейма должна быть не меньше 3 символов";
            request.setAttribute("validation", status);
            request.getRequestDispatcher("jsp/registration.jsp").forward(request, response);
            return;
        }
        if (email.length() == 0) {
            status = "Пожалуйста, заполните поле";
            request.setAttribute("validation", status);
            request.getRequestDispatcher("jsp/registration.jsp").forward(request, response);
            return;
        }
        if (password.length() < 8) {
            status = "Пароль должен содержать не меньше 8 символов";
            request.setAttribute("validation", status);
            request.getRequestDispatcher("jsp/registration.jsp").forward(request, response);
            return;
        }
        if (password.equals(password2)) {

            UserForm userForm = new UserForm();
            userForm.setNickname(nickname);
            userForm.setEmail(email);
            userForm.setPassword(password);

            User user = usersService.register(userForm);
            if (user != null) {

                String cookieValue = UUID.randomUUID().toString();
                System.out.println(cookieValue);
                Cookie cookie = new Cookie("auth", cookieValue);
                cookie.setMaxAge(10 * 60 * 60);

                response.addCookie(cookie);
                response.addCookie(new Cookie("nickname", nickname));
                response.sendRedirect("/home");
                return;
            } else {
                status = "Не удалось зарегистрироваться";
            }
        } else {
            status = "Пароли не совпадают";
        }

        request.setAttribute("validation", status);

        request.getRequestDispatcher("jsp/registration.jsp").forward(request, response);
    }

 */
}