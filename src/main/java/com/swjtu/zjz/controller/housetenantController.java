package com.swjtu.zjz.controller;

import com.swjtu.zjz.dao.houseownerMapper;
import com.swjtu.zjz.dao.housetenantMapper;
import com.swjtu.zjz.dao.ownerAccountMapper;
import com.swjtu.zjz.dao.tenantAccountMapper;
import com.swjtu.zjz.model.HouseOwner;
import com.swjtu.zjz.model.HouseTenant;
import com.swjtu.zjz.model.OwnerAccount;
import com.swjtu.zjz.model.TenantAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.Date;

@Controller
public class housetenantController {
    @Autowired
    private tenantAccountMapper tenantAccountMapper;

    @Autowired
    private housetenantMapper housetenantMapper;

    /*
       查找语句：get请求
       修改语句：put请求       重定向
       添加语句：Post请求      重定向
       删除语句：delete请求    重定向
   */

    @GetMapping("/tenants")
    public String judge(Model model, HttpSession session) {
        TenantAccount tenantAccount = tenantAccountMapper.select((String) session.getAttribute("loginUser"));
        System.out.println("看看情况！！！" + tenantAccount);
        if (tenantAccount.getTenant_identitynum() == null) {
            System.out.println("暂时没有数据，去了添加信息界面！");
            return "tenant/addhousetenant";
        }
        System.out.println("有数据，去了展示信息界面！");
        return "redirect:/showtenant";
    }

    @PostMapping("/tenant")
    public String addOwnerAccount(@RequestParam("identitynum") String identitynum,
                                  @RequestParam("name") String name,
                                  @RequestParam("sex") char sex, HttpSession session,
                                  @RequestParam("age") Date age, Model model){
        HouseTenant houseTenant = new HouseTenant(identitynum, name, sex, age);
        housetenantMapper.addhousetenant(houseTenant);
        System.out.println("添加了一条实名认证" + houseTenant);
        String phonenum = (String)session.getAttribute("loginUser");
        tenantAccountMapper.updateTenantAccountIdentitynum(identitynum,phonenum);
        return "redirect:/tenants";
    }

    @GetMapping("/showtenant")
    public String showTenantAccount(HttpSession session,Model model){
        TenantAccount tenantAccount = tenantAccountMapper.select((String) session.getAttribute("loginUser"));
        System.out.println("看一下实名认证是不是空的！" + tenantAccount);
        HouseTenant houseTenant = housetenantMapper.findHouseTenant(tenantAccount.getTenant_identitynum());
        model.addAttribute("houseTenant", houseTenant);
        return "tenant/showhousetenant";
    }
}
