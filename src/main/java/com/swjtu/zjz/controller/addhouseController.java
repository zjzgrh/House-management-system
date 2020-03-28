package com.swjtu.zjz.controller;

import com.swjtu.zjz.bean.House;
import com.swjtu.zjz.mapper.HouseMapper;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class addhouseController {

    @Autowired
    private HouseMapper houseMapper;

    @PostMapping("/emp")
    public String addHouse(@RequestParam("Address") String Address,
                           @RequestParam("Monthlyrent") Integer Monthlyrent,
                           @RequestParam("Detail") String Detail,
                           @RequestParam("Area") Integer Area){
        House house = new House(Address,Monthlyrent,Detail,Area);
        houseMapper.addhouse(house);
        return "redirect:/emps";
    }
}
