package com.swjtu.zjz.controller;

import com.alibaba.druid.util.StringUtils;
import com.swjtu.zjz.bean.OwnerAccount;
import com.swjtu.zjz.mapper.OwnerAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class signinController {

    @Autowired
    private OwnerAccountMapper ownerAccountMapper;

    @PostMapping(value = "/user/signin")
    public String signin(@RequestParam("phonenum") String phonenum,
                         @RequestParam("password") String password,
                         @RequestParam("role") String role,
                         Model model){
        //用户名和密码都为空
        if(StringUtils.isEmpty(phonenum) && StringUtils.isEmpty(password)){
            model.addAttribute("msg","请输入用户名和密码！");
            return "redirect:/signin";
        //用户名不为空，密码为空
        }else if(!StringUtils.isEmpty(phonenum) && StringUtils.isEmpty(password)){
            OwnerAccount ownerAccount = ownerAccountMapper.select(phonenum);
            //用户名被注册
            if(ownerAccount != null){
                model.addAttribute("msg","用户名已被注册！！！");
                return "signin";
            }
            model.addAttribute("phonenum",phonenum);
            model.addAttribute("msg","请输入密码！");
            return "signin";
        //用户名不为空，密码为空
        }else if(StringUtils.isEmpty(phonenum) && !StringUtils.isEmpty(password)){
            model.addAttribute("password",password);
            model.addAttribute("msg","请输入手机号！");
            return "signin";
        //用户名密码都不为空
        }else{
            OwnerAccount ownerAccount = ownerAccountMapper.select(phonenum);
            //判断用户名是否被注册
            if(ownerAccount != null){
                model.addAttribute("phonenum",phonenum);
                model.addAttribute("msg","用户名已被注册！！！");
                return "signin";
            }
            //将用户名写入数据库
            OwnerAccount ownerAccount1 = new OwnerAccount();
            ownerAccount1.setPhonenum(phonenum);
            ownerAccount1.setPassword(password);
            ownerAccount1.setRole(role);
            ownerAccountMapper.insert(ownerAccount1);
            //System.out.println(ownerAccount1);
            //跳转到登录页面
            return "redirect:/login";
        }
    }
}
