package ru.kpfu.itis.services;

import ru.kpfu.itis.models.dto.AuthDto;
import ru.kpfu.itis.models.forms.UserForm;
import ru.kpfu.itis.models.entities.User;

import javax.servlet.http.Cookie;

public interface UsersService {
    User register(UserForm userForm);
    Cookie signIn(AuthDto authDto);
    User findUserByCookieValue(String cookieValue);
}
