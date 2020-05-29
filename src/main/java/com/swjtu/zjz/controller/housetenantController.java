package com.swjtu.zjz.controller;

import com.swjtu.zjz.dao.housetenantMapper;
import com.swjtu.zjz.model.HouseOwner;
import com.swjtu.zjz.model.HouseTenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Date;

@Controller
public class housetenantController {

    @Autowired
    private housetenantMapper housetenantMapper;

    /*
       查找语句：get请求
       修改语句：put请求       重定向
       添加语句：Post请求      重定向
       删除语句：delete请求    重定向
   */

//账户信息
    @GetMapping("/tenantaccs")
    public String tenantaccount(Model model, HttpSession session){

        HouseTenant houseTenant = housetenantMapper.findTenantid((Integer) session.getAttribute("userId"));

        model.addAttribute("houseTenant", houseTenant);
        System.out.println(houseTenant);
        return "acc/showtenantaccount";
    }

    @GetMapping("/tenantacc/{id}")
    private String toUpdateOwnerAccount(@PathVariable("id") Integer id, Model model, HttpSession session){

        HouseTenant houseTenant = housetenantMapper.findTenantid((id));
        System.out.println("待修改的数据" + houseTenant);
        model.addAttribute("houseTenant",houseTenant);
        return "acc/updatetenantaccount";
    }

    @PutMapping("/tenantacc")
    private String updateOwnerAccount(@RequestParam("phonenum") String phonenum, @RequestParam("password") String password,
                                      @RequestParam("nickname") String nickname, @RequestParam("gender") char gender,
                                      @RequestParam("age") Date age,@RequestParam("id") Integer id,
                                      HttpSession session){

/*        char thegender;
        if(gender.equals("男"))
            thegender = '1';
        else
            thegender = '0';*/
        HouseTenant houseTenant = new HouseTenant(phonenum, password, nickname, gender, age);
        houseTenant.setTenant_id(id);
        housetenantMapper.updateHousetenant(houseTenant);
        //把更新后的用户重新写入到session
        session.setAttribute("loginUser",phonenum);
        return "redirect:/tenantaccs";

    }

    @GetMapping("/tenants")
    public String judge(Model model, HttpSession session) {
        HouseTenant houseTenant = housetenantMapper.findTenantid((Integer) session.getAttribute("userId"));
        System.out.println("看看情况！！！" + houseTenant);
        if (houseTenant.getTenant_identitynum() == null) {
            System.out.println("暂时没有数据，去了添加信息界面！");
            return "tenant/addhousetenant";
        }
        System.out.println("有数据，去了展示信息界面！");
        return "redirect:/showtenant";
    }

    @PostMapping("/tenant")
    public String addOwnerAccount(@RequestParam("identitynum") String identitynum,
                                  @RequestParam("name") String name, Model model,
                                  HttpSession session){

        Integer tenant_id = (Integer) session.getAttribute("userId");

        housetenantMapper.updateHousetenantIdentitynum(identitynum,name,tenant_id);
        System.out.println("添加了一条实名认证" + housetenantMapper.findTenantid(tenant_id));

        return "redirect:/tenants";
    }

    @GetMapping("/showtenant")
    public String showTenantAccount(HttpSession session,Model model){

        HouseTenant houseTenant = housetenantMapper.findTenantid((Integer) session.getAttribute("userId"));

        System.out.println("看一下实名认证是不是空的！" + houseTenant);
        model.addAttribute("houseTenant", houseTenant);

        return "tenant/showhousetenant";
    }
}
