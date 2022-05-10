package ru.kpfu.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.services.CookieService;
import ru.kpfu.itis.services.ProductsService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ProductController {

    @Autowired
    ProductsService productsService;

    @RequestMapping(method = RequestMethod.GET, value = "/products")
    private ModelAndView productPage(String redirect, HttpServletResponse response, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        Cookie nicknameCookie = CookieService.getCookie(request, "nickname");
        System.out.println(nicknameCookie);


        return modelAndView;
    }
}
