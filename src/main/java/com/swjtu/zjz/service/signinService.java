package com.swjtu.zjz.service;

import com.alibaba.druid.util.StringUtils;
import com.swjtu.zjz.model.OwnerAccount;
import com.swjtu.zjz.model.TenantAccount;
import com.swjtu.zjz.service.impl.signinServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class signinService implements signinServiceImpl {

    @Autowired
    private com.swjtu.zjz.dao.ownerAccountMapper ownerAccountMapper;

    @Autowired
    private com.swjtu.zjz.dao.tenantAccountMapper tenantAccountMapper;

    @Override
    public String signin(String phonenum, String password, String role, Model model) {
        //用户名和密码都为空
        if (StringUtils.isEmpty(phonenum) && StringUtils.isEmpty(password)) {
            model.addAttribute("msg", "请输入用户名和密码！");
            return "redirect:/signin";
            //用户名不为空，密码为空
        } else if (!StringUtils.isEmpty(phonenum) && StringUtils.isEmpty(password)) {
            OwnerAccount ownerAccount = ownerAccountMapper.select(phonenum);
            //用户名被注册
            if (ownerAccount != null) {
                model.addAttribute("msg", "用户名已被注册！！！");
                return "signin";
            }
            model.addAttribute("phonenum", phonenum);
            model.addAttribute("msg", "请输入密码！");
            return "signin";
            //用户名不为空，密码为空
        } else if (StringUtils.isEmpty(phonenum) && !StringUtils.isEmpty(password)) {
            model.addAttribute("password", password);
            model.addAttribute("msg", "请输入手机号！");
            return "signin";
            //用户名密码都不为空
        } else {
            //判断角色
            if (role.equals("owner")) {
                OwnerAccount ownerAccount = ownerAccountMapper.select(phonenum);
                //判断用户名是否被注册
                if (ownerAccount != null) {
                    model.addAttribute("phonenum", phonenum);
                    model.addAttribute("msg", "用户名已被注册！！！");
                    return "signin";
                }
                //将用户名写入数据库
                OwnerAccount ownerAccount1 = new OwnerAccount(phonenum,password);
                ownerAccountMapper.insert(ownerAccount1);
                //System.out.println(ownerAccount1);
                //跳转到登录页面
                return "redirect:/login";
            } else {
                TenantAccount tenantAccount = tenantAccountMapper.select(phonenum);
                //判断用户名是否被注册
                if (tenantAccount != null) {
                    model.addAttribute("phonenum", phonenum);
                    model.addAttribute("msg", "用户名已被注册！！！");
                    return "signin";
                }
                //将用户名写入数据库
                TenantAccount tenantAccount1 = new TenantAccount(phonenum,password);
                tenantAccountMapper.insert(tenantAccount1);
                //System.out.println(ownerAccount1);
                //跳转到登录页面
                return "redirect:/login";
            }
        }
    }
}
