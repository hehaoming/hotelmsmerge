package com.hotelms.controller;

import com.hotelms.bean.UserBean;
import com.hotelms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Login")
public class LoginController {

    @Autowired
    UserService service;

    @RequestMapping("/tologin")
    public String toLogin() {
        return "/WEB-INF/jsp/login/login.jsp";
    }

    @RequestMapping(value = "/tomain")
    public String tomain(UserBean user) {
        if (service.isValidUser(user)) {
            return "/WEB-INF/jsp/main/main.jsp";
        } else {
            return "/WEB-INF/jsp/login/login.jsp";
        }
    }
}
