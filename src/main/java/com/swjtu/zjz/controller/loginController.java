package com.swjtu.zjz.controller;

import com.swjtu.zjz.bean.OwnerAccount;
import com.swjtu.zjz.mapper.OwnerAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class loginController {

    @Autowired
    private  OwnerAccountMapper ownerAccountMapper;

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session, Model model){
        //session.setAttribute("msg","没有权限，请先登录");
//        if(!StringUtils.isEmpty(username) && "123".equals(password)){
//            //登录成功
//            session.setAttribute("loginUser",username);
//            return "redirect:/main.html";
//        }else{
//            //登录失败
//            session.setAttribute("wrong_name","用户名密码错误");
//            return "login";
//        }
        if(StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)){
            model.addAttribute("password",password);
            model.addAttribute("msg","用户名为空啊！！！");
            return "login";
        }else if(!StringUtils.isEmpty(username) && StringUtils.isEmpty(password)){
            model.addAttribute("username",username);
            model.addAttribute("msg","密码为空啊！！！");
            return "login";
        }else if(StringUtils.isEmpty(username) && StringUtils.isEmpty(password)){
            model.addAttribute("msg","用户名和密码为空啊！！！");
            return "login";
        }else {
            OwnerAccount ownerAccount = ownerAccountMapper.select(username);
            if(ownerAccount == null){
                model.addAttribute("password",password);
                model.addAttribute("msg","用户名不存在，请检查用户名或进行注册！");
                return "login";
            }
            System.out.println(ownerAccount);
            if(username.equals(ownerAccount.getPhonenum()) && password.equals(ownerAccount.getPassword())){
                session.setAttribute("loginUser",username);
                return "redirect:/main.html";
            }else {
                model.addAttribute("username",username);
                model.addAttribute("msg","密码错误，请检查密码并重新输入");
                return "login";
            }
        }
    }
}

