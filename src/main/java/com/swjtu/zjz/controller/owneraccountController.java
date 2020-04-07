package com.swjtu.zjz.controller;

import com.swjtu.zjz.dao.ownerAccountMapper;
import com.swjtu.zjz.model.House;
import com.swjtu.zjz.model.OwnerAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class owneraccountController {

    @Autowired
    private ownerAccountMapper ownerAccountMapper;

    @GetMapping("/accs")
    public String owneraccount(Model model, HttpSession session){
        OwnerAccount ownerAccount = ownerAccountMapper.select((String)session.getAttribute("loginUser"));
        model.addAttribute("ownerAccount", ownerAccount);
        System.out.println(ownerAccount);
        return "acc/showowneraccount";
    }

    @GetMapping("/acc")
    private String toUpdateOwnerAccount(Model model, HttpSession session){
        OwnerAccount ownerAccount = ownerAccountMapper.select((String)session.getAttribute("loginUser"));
//        System.out.println("看看修改账号时，有没有获取到手机号"+phonenum);
        model.addAttribute("ownerAccount", ownerAccount);
        return "acc/updateowneraccount";
    }

    @PutMapping("/acc")
    private String updateOwnerAccount(@RequestParam("phonenum") String phonenum,
                                      @RequestParam("password") String password, HttpSession session){

        ownerAccountMapper.updateOwnerAccount(phonenum,password,(String)session.getAttribute("loginUser"));
        session.setAttribute("loginUser",phonenum);
        return "redirect:/accs";
    }
}
