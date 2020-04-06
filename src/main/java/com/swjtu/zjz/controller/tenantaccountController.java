package com.swjtu.zjz.controller;

import com.swjtu.zjz.dao.ownerAccountMapper;
import com.swjtu.zjz.dao.tenantAccountMapper;
import com.swjtu.zjz.model.OwnerAccount;
import com.swjtu.zjz.model.TenantAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class tenantaccountController {
    @Autowired
    private tenantAccountMapper tenantAccountMapper;

    @GetMapping("/tenantaccs")
    public String tenantaccount(Model model, HttpSession session){
        TenantAccount tenantAccount = tenantAccountMapper.select((String) session.getAttribute("loginUser"));
        model.addAttribute("tenantAccount", tenantAccount);
        System.out.println(tenantAccount);
        return "acc/showtenantaccount";
    }

    @GetMapping("/tenantacc/{phonenum}")
    private String toUpdateOwnerAccount(@PathVariable("phonenum") String phonenum, Model model){
        TenantAccount tenantAccount = tenantAccountMapper.select(phonenum);
        model.addAttribute("tenantAccount", tenantAccount);
        return "acc/updatetennataccount";
    }

    @PutMapping("/tenantacc")
    private String updateOwnerAccount(@RequestParam("phonenum") String phonenum,
                                      @RequestParam("password") String password){
        TenantAccount tenantAccount = new TenantAccount(phonenum, password);
        tenantAccountMapper.updateTenantAccount(tenantAccount);
        System.out.println(tenantAccount);
        return "redirect:/tenantaccs";
    }
}
