package com.swjtu.zjz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class loginController {

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                         HttpSession session){
        //session.setAttribute("msg","没有权限，请先登录");
        if(!StringUtils.isEmpty(username) && "123".equals(password)){
            //登录成功
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else{
            //登录失败
            session.setAttribute("wrong_name","用户名密码错误");
            return "login";
        }
    }
}

