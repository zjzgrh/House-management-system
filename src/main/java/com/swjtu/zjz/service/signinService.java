package com.swjtu.zjz.service;

import com.swjtu.zjz.dao.houseownerMapper;
import com.swjtu.zjz.dao.housetenantMapper;
import com.swjtu.zjz.model.HouseOwner;
import com.swjtu.zjz.model.HouseTenant;
import com.swjtu.zjz.service.impl.signinServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.thymeleaf.util.StringUtils;

@Service
public class signinService implements signinServiceImpl {

    @Autowired
    private houseownerMapper houseownerMapper;

    @Autowired
    private housetenantMapper housetenantMapper;

    @Override
    public String signin(String phonenum, String password, String role, Model model) {

        //用户名为空
        if(StringUtils.isEmpty(phonenum) && !StringUtils.isEmpty(password)){
            model.addAttribute("password",password);
            model.addAttribute("msg","用户名为空啊！！！");
            System.out.println("用户名为空啊");
            return "signin";
            //密码为空
        }else if(!StringUtils.isEmpty(phonenum) && StringUtils.isEmpty(password)){
            model.addAttribute("phonenum",phonenum);
            model.addAttribute("msg","密码为空啊！！！");
            System.out.println("密码为空啊");
            return "signin";
            //用户名和密码都为空
        }else if(StringUtils.isEmpty(phonenum) && StringUtils.isEmpty(password)){
            model.addAttribute("msg","用户名和密码为空啊！！！");
            System.out.println("用户名和密码为空啊");
            return "signin";
            //用户名和密码都不为空，判断用户名和密码是否在数据库
        } else {
            //判断角色
            //房主用户的注册
            if (role.equals("owner")) {

                //判断用户名格式，是否为11位手机号
                if(phonenum.length() != 11){
                    model.addAttribute("password",password);
                    model.addAttribute("msg","用户名格式错误，为11位手机号！");
                    return "signin";
                }
                //判断密码格式，是否为6-20位
                if(password.length() < 6 || password.length() > 20){
                    model.addAttribute("phonenum",phonenum);
                    model.addAttribute("msg","密码格式错误，为6-20位字符或数字！");
                    return "signin";
                }

                HouseOwner houseOwner = houseownerMapper.findPhonenum(phonenum);

                //判断用户名是否被注册
                if (houseOwner != null) {
                    model.addAttribute("phonenum", phonenum);
                    model.addAttribute("password", password);
                    model.addAttribute("msg", "用户名已被注册！！！");
                    return "signin";
                }
                //将用户名和密码写入数据库
                houseownerMapper.addHouseownerAccount(phonenum,password);
                //跳转到登录页面
                return "redirect:/login";
            } else {
                //租客用户的注册

                //判断用户名格式，是否为11位手机号
                if(phonenum.length() != 11){
                    model.addAttribute("password",password);
                    model.addAttribute("msg","用户名格式错误，为11位手机号！");
                    return "signin";
                }
                //判断密码格式，是否为6-20位
                if(password.length() < 6 || password.length() > 20){
                    model.addAttribute("phonenum",phonenum);
                    model.addAttribute("msg","密码格式错误，为6-20位字符或数字！");
                    return "signin";
                }

                HouseTenant houseTenant = housetenantMapper.findPhonenum(phonenum);

                //判断用户名是否被注册
                if (houseTenant != null) {
                    model.addAttribute("phonenum", phonenum);
                    model.addAttribute("password", password);
                    model.addAttribute("msg", "用户名已被注册！！！");
                    return "signin";
                }
                //将用户名写入数据库
                housetenantMapper.addHousetenantAccount(phonenum,password);
                //跳转到登录页面
                return "redirect:/login";
            }
        }
    }
}
