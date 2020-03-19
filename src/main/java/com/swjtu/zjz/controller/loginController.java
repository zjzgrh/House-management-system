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
                        @RequestParam("role") String role,
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
        //        用户名为空
        if(StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)){
            model.addAttribute("password",password);
            model.addAttribute("msg","用户名为空啊！！！");
            return "login";
        //密码为空
        }else if(!StringUtils.isEmpty(username) && StringUtils.isEmpty(password)){
            model.addAttribute("username",username);
            model.addAttribute("msg","密码为空啊！！！");
            return "login";
            //用户名和密码都为空
        }else if(StringUtils.isEmpty(username) && StringUtils.isEmpty(password)){
            model.addAttribute("msg","用户名和密码为空啊！！！");
            return "login";
            //用户名和密码都不为空，判断用户名和密码是否在数据库
        }else {
            //查询数据库
            OwnerAccount ownerAccount = ownerAccountMapper.select(username);
            //用户名不在数据库时，警告用户名不存在，提示用户去注册
            if(ownerAccount == null){
                model.addAttribute("password",password);
                model.addAttribute("msg","用户名不存在，请检查用户名或进行注册！");
                return "login";
            }
            //用户名存在数据库，判断密码和角色是否正确，正确就进入主页
            if(username.equals(ownerAccount.getPhonenum()) && password.equals(ownerAccount.getPassword()) && role.equals(ownerAccount.getRole())){
                session.setAttribute("loginUser",username);
                if(role.equals("owner")){
                    return "redirect:/main.html";
                }else {
                    return "redirect:/rent_main.html";
                }
            //若密码或角色不对，进行相应的提示
            }else {
                model.addAttribute("username",username);
                model.addAttribute("msg","密码错误，请检查密码并重新输入");
                return "login";
            }
        }
    }
}

