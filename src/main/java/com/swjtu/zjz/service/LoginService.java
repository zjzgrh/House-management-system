package com.swjtu.zjz.service;

import com.swjtu.zjz.dao.ownerAccountMapper;
import com.swjtu.zjz.dao.tenantAccountMapper;
import com.swjtu.zjz.model.OwnerAccount;
import com.swjtu.zjz.model.TenantAccount;
import com.swjtu.zjz.service.impl.loginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Service
public class LoginService implements loginServiceImpl {

    @Autowired
    private ownerAccountMapper ownerAccountMapper;

    @Autowired
    private tenantAccountMapper tenantAccountMapper;

    @Override
    public String login(String username, String password, String role, HttpSession session, Model model) {
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
            //判断角色
            if (role.equals("owner")) {
                //查询数据库
                OwnerAccount ownerAccount = ownerAccountMapper.select(username);
                //用户名不在数据库时，警告用户名不存在，提示用户去注册
                if (ownerAccount == null) {
                    model.addAttribute("password", password);
                    model.addAttribute("msg", "用户名不存在，请检查用户名或进行注册！");
                    return "login";
                }
                //用户名存在数据库，判断密码和角色是否正确，正确就进入主页
                if (username.equals(ownerAccount.getPhonenum()) && password.equals(ownerAccount.getPassword())) {
                    session.setAttribute("loginUser", username);
                    return "redirect:/main.html";
                    //若密码或角色不对，进行相应的提示
                } else {
                    model.addAttribute("username", username);
                    model.addAttribute("msg", "密码错误，请检查密码并重新输入");
                    return "login";
                }
            } else {
                //查询数据库
                TenantAccount tenantAccount = tenantAccountMapper.select(username);
                //用户名不在数据库时，警告用户名不存在，提示用户去注册
                if (tenantAccount == null) {
                    model.addAttribute("password", password);
                    model.addAttribute("msg", "用户名不存在，请检查用户名或进行注册！");
                    return "login";
                }
                //用户名存在数据库，判断密码和角色是否正确，正确就进入主页
                if (username.equals(tenantAccount.getPhonenum()) && password.equals(tenantAccount.getPassword())) {
                    //用户名写入session
                    session.setAttribute("loginUser", username);
                    return "redirect:/rent_main.html";
                    //若密码或角色不对，进行相应的提示
                } else {
                    model.addAttribute("username", username);
                    model.addAttribute("msg", "密码错误，请检查密码并重新输入");
                    return "login";
                }
            }
        }
    }
}
