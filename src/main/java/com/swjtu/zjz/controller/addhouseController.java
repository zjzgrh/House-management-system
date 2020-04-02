package com.swjtu.zjz.controller;

import com.swjtu.zjz.model.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class addhouseController {

    @Autowired
    private com.swjtu.zjz.dao.houseMapper houseMapper;

    @PostMapping("/emp")
    public String addHouse(@RequestParam("Address") String Address, @RequestParam("Monthlyrent") Integer Monthlyrent,
                           @RequestParam("Detail") String Detail, @RequestParam("Area") Integer Area,
                           @RequestParam("Use") String Use, @RequestParam("Type") String Type,
                           @RequestParam("Floor") Integer Floor,@RequestParam("Decoration") String Decoration,
                           @RequestParam("Identitynum") String Identitynum, @RequestParam("Situation") char Situation){
        House house = new House(Address,Monthlyrent,Detail,Area,Use,Type,Floor,Decoration,Identitynum,Situation);
        houseMapper.addhouse(house);
        System.out.println("添加了一个房源信息：" + house);
        return "redirect:/emps";
    }
}
