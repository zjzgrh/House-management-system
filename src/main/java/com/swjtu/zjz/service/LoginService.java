package com.swjtu.zjz.service;

import com.swjtu.zjz.dao.houseownerMapper;
import com.swjtu.zjz.dao.housetenantMapper;
import com.swjtu.zjz.model.HouseOwner;
import com.swjtu.zjz.model.HouseTenant;
import com.swjtu.zjz.service.impl.loginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Service
public class LoginService implements loginServiceImpl {

    @Autowired
    private houseownerMapper houseownerMapper;

    @Autowired
    private housetenantMapper housetenantMapper;

    @Override
    public String login(String phonenum, String password, String role, HttpSession session, Model model) {
        //用户名为空
        if(StringUtils.isEmpty(phonenum) && !StringUtils.isEmpty(password)){
            model.addAttribute("password",password);
            model.addAttribute("msg","用户名为空啊！！！");
            return "login";
            //密码为空
        }else if(!StringUtils.isEmpty(phonenum) && StringUtils.isEmpty(password)){
            model.addAttribute("phonenum",phonenum);
            model.addAttribute("msg","密码为空啊！！！");
            return "login";
            //用户名和密码都为空
        }else if(StringUtils.isEmpty(phonenum) && StringUtils.isEmpty(password)){
            model.addAttribute("msg","用户名和密码为空啊！！！");
            return "login";
            //用户名和密码都不为空，判断用户名和密码是否在数据库
        }else {
            //判断角色
            //房主登录判断
            if (role.equals("owner")) {
                //查询数据库
                HouseOwner houseOwner = houseownerMapper.findPhonenum(phonenum);

                //用户名不在数据库时，警告用户名不存在，提示用户去注册
                if (houseOwner == null) {
                    model.addAttribute("phonenum", phonenum);
                    model.addAttribute("password", password);
                    model.addAttribute("msg", "用户名不存在，请检查用户名或进行注册！");
                    return "login";
                }
                //用户名存在数据库，判断密码是否正确，正确就进入主页
                if ( password.equals(houseOwner.getPassword())) {
                    session.setAttribute("loginUser", phonenum);
                    session.setAttribute("userId", houseownerMapper.getHouseownerId(phonenum));
                    return "index";
                //若密码不对，进行相应的提示
                } else {
                    model.addAttribute("phonenum", phonenum);
                    model.addAttribute("msg", "密码错误，请检查密码并重新输入");
                    return "login";
                }
                //房客登录判断
            } else {
                //查询数据库
                HouseTenant houseTenant = housetenantMapper.findPhonenum(phonenum);

                //用户名不在数据库时，警告用户名不存在，提示用户去注册
                if (houseTenant == null) {
                    model.addAttribute("phonenum", phonenum);
                    model.addAttribute("password", password);
                    model.addAttribute("msg", "用户名不存在，请检查用户名或进行注册！");
                    return "login";
                }
                //用户名存在数据库，判断密码是否正确，正确就进入主页
                if (password.equals(houseTenant.getPassword())) {
                    //用户名写入session
                    session.setAttribute("loginUser", phonenum);
                    session.setAttribute("userId", housetenantMapper.getHousetenantId(phonenum));
                    return "rent/index";
                //若密码不对，进行相应的提示
                } else {
                    model.addAttribute("phonenum", phonenum);
                    model.addAttribute("msg", "密码错误，请检查密码并重新输入");
                    return "login";
                }
            }
        }
    }
}
