package com.swjtu.zjz.controller;

import com.swjtu.zjz.dao.houseownerMapper;
import com.swjtu.zjz.model.House;
import com.swjtu.zjz.model.HouseOwner;
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
    private houseownerMapper houseownerMapper;

    @GetMapping("/owner")
    public String addHouse(Model model, HttpSession session){
        HouseOwner houseOwner = houseownerMapper.findHouseOwner((String) session.getAttribute("loginUser"));
        System.out.println(houseOwner);
        //houseownerMapper.addhouseowner(houseOwner);
//        System.out.println("查看一条个人信息：" + houseOwner);
        return "owner/houseowner";
    }

}
