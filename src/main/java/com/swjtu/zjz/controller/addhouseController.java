package com.swjtu.zjz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class addhouseController {

    @PostMapping("/emp")
    public String addHouse(){

        return "emp/houselist";
    }
}
