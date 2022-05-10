package ru.kpfu.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.models.dto.AuthDto;
import ru.kpfu.itis.models.dto.SignUpDto;
import ru.kpfu.itis.models.forms.UserForm;
import ru.kpfu.itis.models.entities.User;
import ru.kpfu.itis.services.UsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(method = RequestMethod.GET, value = "/signIn")
    private ModelAndView authorisationPage(String redirect){
        ModelAndView modelAndView = new ModelAndView();
        if (redirect != null){
            modelAndView.setViewName("redirect:/" + redirect);
            return modelAndView;
        }
        modelAndView.setViewName("authorisation");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signIn")
    private ModelAndView authorise(AuthDto authDto, HttpServletResponse response){
        Cookie cookie = usersService.signIn(authDto);
        ModelAndView modelAndView = new ModelAndView();
        if (cookie != null){
            response.addCookie(cookie);
            response.addCookie(new Cookie("email", authDto.getEmail()));
            modelAndView.setViewName("redirect:/home");
            return modelAndView;
        }
        modelAndView.addObject("signInStatus", "Неправильный логин или пароль");
        modelAndView.setViewName("redirect:/signIn");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/registration")
    private ModelAndView signUpPage(String redirect){
        ModelAndView modelAndView = new ModelAndView();
        if (redirect != null){
            modelAndView.setViewName("redirect:/" + redirect);
            return modelAndView;
        }
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/registration")
    private ModelAndView signUp(SignUpDto signUpDto, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(signUpDto.toString());
        String nickname = signUpDto.getNickname();
        String email = signUpDto.getEmail();
        String password = signUpDto.getPassword();
        String password2 = signUpDto.getPassword2();
        String status;
        if (nickname.length() < 3){
            status = "Никнейм должен состоять как минимум из 3 символов";
            modelAndView.addObject("validation", status);
            modelAndView.setViewName("redirect:/registration");
            return modelAndView;
        }
        if (email.length() == 0){
            status = "Это поле не может быть пустым";
            modelAndView.addObject("validation", status);
            modelAndView.setViewName("redirect:/registration");
            return modelAndView;
        }
        if (password.equals(password2)){
            UserForm userForm = new UserForm(nickname, email, password);
            User user = usersService.register(userForm);
            if (user != null){
                AuthDto authDto = new AuthDto().builder()
                        .email(email)
                        .password(password)
                        .build();
                Cookie cookie = usersService.signIn(authDto);
                cookie.setMaxAge(10*60*60);
                response.addCookie(cookie);
                //response.addCookie(new Cookie("nickname", nickname));
                modelAndView.setViewName("redirect:/home");
                return modelAndView;
            } else {
                status = "Проблемы с созданием аккаунта";
            }
        } else {
            status = "Проверьте правильность введения паролей";
        }
        modelAndView.addObject("validation", status);
        modelAndView.setViewName("redirect:/registration");
        return modelAndView;
    }

}
