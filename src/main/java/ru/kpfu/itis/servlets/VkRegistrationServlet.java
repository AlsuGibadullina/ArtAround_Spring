package ru.kpfu.itis.servlets;

import javax.servlet.http.HttpServlet;

//@WebServlet("/vk")
public class VkRegistrationServlet extends HttpServlet {
/*
    private UsersService usersService;

    private final String URL = "jdbc:postgresql://localhost:5432/maven";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "sadafa54ga";

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            UsersRepository usersRepository = new UsersRepositoryImpl1(connection);
            usersService = new UsersServiceImpl(usersRepository);
        } catch (SQLException | ClassNotFoundException e) {
            throw new UnavailableException("Сайт недоступен!!!");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            TransportClient transportClient = HttpTransportClient.getInstance();
            VkApiClient vk = new VkApiClient(transportClient, new Gson(), 5);

            String code = req.getParameter("code");
            UserAuthResponse authResponse = vk.oauth()
                    .userAuthorizationCodeFlow(7998861, "i1PRtAQB2gUPzzwLuuT2", "http://localhost:8080/vk", code)
                    .execute();



            UserActor actor = new UserActor(authResponse.getUserId(), authResponse.getAccessToken());
            System.out.println(actor.getAccessToken());


            UserXtrCounters account = vk.users().get(actor)
                    .userIds(actor.getId().toString())
                    .lang(Lang.RU)
                    .unsafeParam("v", "5.131")
                    .execute().get(0);

            System.out.println(account.getLastName() + account.getFirstName());

           UserForm userForm = new UserForm();
           userForm.setNickname(account.getFirstName());
           userForm.setEmail("vk");
            userForm.setPassword("sss");
            usersService.register(userForm);

            req.getRequestDispatcher("/jsp/main.jsp").forward(req, resp);

        } catch (ClientException e) {
            e.printStackTrace();
        } catch (ApiException e) {
            e.printStackTrace();
        } /*catch (ClientException e) {
            e.printStackTrace();
        } catch (ApiException e) {
            e.printStackTrace();
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

 */

}
