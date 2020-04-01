package com.swjtu.zjz.controller;

import com.swjtu.zjz.service.impl.signinServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class signinController {

   @Autowired
   private signinServiceImpl signinService;

    @PostMapping(value = "/user/signin")
    public String signin(@RequestParam("phonenum") String phonenum,
                         @RequestParam("password") String password,
                         @RequestParam("role") String role,
                         Model model) {
        return signinService.signin(password, password, role, model);
    }
}
