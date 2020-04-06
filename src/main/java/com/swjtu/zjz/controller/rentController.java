package com.swjtu.zjz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class rentController {

    @GetMapping("/houseapply")
    public String houseapplylist(){

        return "rentmanage/houseapplylist";
    }

}
