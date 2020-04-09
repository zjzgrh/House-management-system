package com.swjtu.zjz.service;

import com.alibaba.druid.util.StringUtils;
import com.swjtu.zjz.dao.houseownerMapper;
import com.swjtu.zjz.dao.housetenantMapper;
import com.swjtu.zjz.model.HouseOwner;
import com.swjtu.zjz.model.HouseTenant;
import com.swjtu.zjz.service.impl.signinServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class signinService implements signinServiceImpl {

    @Autowired
    private houseownerMapper houseownerMapper;

    @Autowired
    private housetenantMapper housetenantMapper;

    @Override
    public String signin(String phonenum, String password, String role, Model model) {
        //用户名和密码都为空
        if (StringUtils.isEmpty(phonenum) && StringUtils.isEmpty(password)) {
            model.addAttribute("msg", "请输入用户名和密码！");
            return "redirect:/signin";
        //用户名不为空，密码为空
        } else if (!StringUtils.isEmpty(phonenum) && StringUtils.isEmpty(password)) {

            model.addAttribute("phonenum", phonenum);
            model.addAttribute("msg", "请输入密码！");
            return "signin";
        //用户名为空，密码不为空
        } else if (StringUtils.isEmpty(phonenum) && !StringUtils.isEmpty(password)) {
            model.addAttribute("password", password);
            model.addAttribute("msg", "请输入手机号！");
            return "signin";
        //用户名密码都不为空
        } else {
            //判断角色
            if (role.equals("owner")) {
                //房主用户的注册
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
