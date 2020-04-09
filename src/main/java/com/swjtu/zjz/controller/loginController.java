package com.swjtu.zjz.controller;

import com.swjtu.zjz.service.impl.loginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class loginController {

    @Autowired
    private loginServiceImpl loginService;

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("phonenum") String username,
                        @RequestParam("password") String password,
                        @RequestParam("role") String role,
                        HttpSession session, Model model){
        return loginService.login(username, password, role, session, model);
    }
}

