package com.swjtu.zjz.controller;

import com.alibaba.druid.util.StringUtils;
import com.swjtu.zjz.bean.OwnerAccount;
import com.swjtu.zjz.mapper.OwnerAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class signinController {

    @Autowired
    private OwnerAccountMapper ownerAccountMapper;

    @PostMapping("/user/signin")
    public String signin(@RequestParam("phonenum") String phonenum,
                         @RequestParam("password") String password){
        if(!StringUtils.isEmpty(phonenum)){
            OwnerAccount ownerAccount = new OwnerAccount();
            ownerAccount.setPhonenum(phonenum);
            ownerAccount.setPassword(password);
            ownerAccountMapper.insert(ownerAccount);
            System.out.println(ownerAccount);
            return "redirect:/login";
        }else{
            return "signin";
        }
    }
}
