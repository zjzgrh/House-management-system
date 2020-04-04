package com.swjtu.zjz.controller;

import com.swjtu.zjz.dao.houseownerMapper;
import com.swjtu.zjz.dao.ownerAccountMapper;
import com.swjtu.zjz.model.HouseOwner;
import com.swjtu.zjz.model.OwnerAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.Date;

@Controller
public class houseownerController {

    @Autowired
    private ownerAccountMapper ownerAccountMapper;

    @Autowired
    private houseownerMapper houseownerMapper;

    /*
       查找语句：get请求
       修改语句：put请求       重定向
       添加语句：Post请求      重定向
       删除语句：delete请求    重定向
   */

    @GetMapping("/owners")
    public String judge(Model model, HttpSession session) {
        OwnerAccount ownerAccount = ownerAccountMapper.select((String) session.getAttribute("loginUser"));
        System.out.println("看看情况！！！" + ownerAccount);
        if (ownerAccount.getOwner_identitynum() == null) {
            System.out.println("暂时没有数据，去了添加信息界面！");
            return "owner/addhouseowner";
        }
        System.out.println("有数据，去了展示信息界面！");
        return "redirect:/showowner";
    }

    @PostMapping("/owner")
    public String addOwnerAccount(@RequestParam("identitynum") String identitynum,
                                  @RequestParam("name") String name,
                                  @RequestParam("sex") char sex,HttpSession session,
                                  @RequestParam("age") Date age,Model model){
        HouseOwner houseOwner = new HouseOwner(identitynum,name,sex,age);
        houseownerMapper.addhouseowner(houseOwner);
        System.out.println("添加了一条实名认证" + houseOwner);
        String phonenum = (String)session.getAttribute("loginUser");
        ownerAccountMapper.updateOwnerAccountIdentitynum(identitynum,phonenum);
        return "redirect:/owners";
    }

    @GetMapping("/showowner")
    public String showOwnerAccount(HttpSession session,Model model){
        OwnerAccount ownerAccount = ownerAccountMapper.select((String) session.getAttribute("loginUser"));
        System.out.println("看一下实名认证是不是空的！" + ownerAccount);
        HouseOwner houseOwner = houseownerMapper.findHouseOwner(ownerAccount.getOwner_identitynum());
        model.addAttribute("houseOwner", houseOwner);
        return "owner/showhouseowner";
    }

}
