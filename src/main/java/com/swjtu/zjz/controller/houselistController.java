package com.swjtu.zjz.controller;

import com.swjtu.zjz.model.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class houselistController {

    @Autowired
    private com.swjtu.zjz.dao.houseMapper houseMapper;

    /*
        查找语句：get请求
        修改语句：put请求
        添加语句：Post请求
        删除语句：delete请求
    */

    @GetMapping("/emps")
    public String houselist(Model model){
        List<House> houselists = houseMapper.findHouseList();
        model.addAttribute("houselists", houselists);
        return "emp/houselist";
    }

    @GetMapping("/emp")
    public String addhouse(Model model){
        return "emp/addhouse";
    }

    @GetMapping("/emp/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model){
        House house = houseMapper.findHouse(id);
        model.addAttribute("house", house);
        return "emp/addhouse";
    }

    @PutMapping("/emp")
    public String update(@RequestParam("id") Integer id,
                         @RequestParam("Address") String Address, @RequestParam("Monthlyrent") Integer Monthlyrent,
                         @RequestParam("Detail") String Detail, @RequestParam("Area") Integer Area,
                         @RequestParam("Use") String Use, @RequestParam("Type") String Type,
                         @RequestParam("Floor") Integer Floor,@RequestParam("Decoration") String Decoration,
                         @RequestParam("Identitynum") String Identitynum, @RequestParam("Situation") char Situation){
        House house = new House(Address,Monthlyrent,Detail,Area,Use,Type,Floor,Decoration,Identitynum,Situation);
        house.setHouse_id(id);
        System.out.println("待修改的房子信息：" + house);
        houseMapper.updateHouse(house);
        System.out.println("修改了一个房源信息：" + house);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deletehouse(@PathVariable("id") Integer id){
        houseMapper.deleteid(id);
        System.out.println("删除了一个房源信息，房子id为：" + id);
        return "redirect:/emps";
    }

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
