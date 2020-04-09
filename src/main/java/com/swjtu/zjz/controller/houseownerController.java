package com.swjtu.zjz.controller;

import com.swjtu.zjz.dao.houseownerMapper;
import com.swjtu.zjz.model.HouseOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Date;

@Controller
public class houseownerController {

    @Autowired
    private houseownerMapper houseownerMapper;

    /*
       查找语句：get请求
       修改语句：put请求       重定向
       添加语句：Post请求      重定向
       删除语句：delete请求    重定向
   */
//账户信息
    //查看账户信息
    @GetMapping("/accs")
    public String owneraccount(Model model, HttpSession session){
        HouseOwner houseOwner = houseownerMapper.findOwnerid((Integer) session.getAttribute("userId"));

        model.addAttribute("houseOwner", houseOwner);
        System.out.println(houseOwner);
        return "acc/showowneraccount";
    }

    //跳转到修改界面
    @GetMapping("/acc/{id}")
    private String toUpdateOwnerAccount(@PathVariable("id") Integer id, Model model, HttpSession session){
        HouseOwner houseOwner = houseownerMapper.findOwnerid((id));
        System.out.println("待修改的数据" + houseOwner);
        model.addAttribute("houseOwner",houseOwner);
        return "acc/updateowneraccount";
    }

    @PutMapping("/acc")
    private String updateOwnerAccount(@RequestParam("phonenum") String phonenum, @RequestParam("password") String password,
                                      @RequestParam("nickname") String nickname, @RequestParam("gender") char gender,
                                      @RequestParam("age") Date age,@RequestParam("id") Integer id,
                                      HttpSession session){

        HouseOwner houseOwner = new HouseOwner(phonenum, password, nickname, gender, age);
        houseOwner.setOwner_id(id);
        System.out.println("修改的数据： " + houseOwner);
        houseownerMapper.updateHouseowner(houseOwner);
        //把更新后的用户重新写入到session
        session.setAttribute("loginUser",phonenum);
        return "redirect:/accs";
    }

//添加查看实名或者说身份证信息
    @GetMapping("/owners")
    public String judge(Model model, HttpSession session) {
        HouseOwner houseOwner = houseownerMapper.findOwnerid((Integer) session.getAttribute("userId"));

        System.out.println("看看情况！！！" + houseOwner);
        if (houseOwner.getOwner_identitynum() == null) {
            System.out.println("暂时没有数据，去了添加信息界面！");
            return "owner/addhouseowner";
        }
        System.out.println("有数据，去了展示信息界面！");
        return "redirect:/showowner";
    }

    @PostMapping("/owner")
    public String addOwnerAccount(@RequestParam("identitynum") String identitynum,
                                  @RequestParam("name") String name, Model model,
                                  HttpSession session){
        Integer owner_id = (Integer) session.getAttribute("userId");
        houseownerMapper.updateHouseownerIdentitynum(identitynum,name,owner_id);

        System.out.println("添加了一条实名认证" + houseownerMapper.findOwnerid(owner_id));

        return "redirect:/owners";
    }

    @GetMapping("/showowner")
    public String showOwnerAccount(HttpSession session,Model model){
        HouseOwner houseOwner = houseownerMapper.findOwnerid((Integer) session.getAttribute("userId"));

        System.out.println("看一下实名认证是不是空的！" + houseOwner);

        model.addAttribute("houseOwner", houseOwner);
        return "owner/showhouseowner";
    }

}
