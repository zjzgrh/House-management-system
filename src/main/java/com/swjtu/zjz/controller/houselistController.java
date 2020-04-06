package com.swjtu.zjz.controller;

import com.swjtu.zjz.dao.houseMapper;
import com.swjtu.zjz.dao.ownerAccountMapper;
import com.swjtu.zjz.model.House;
import com.swjtu.zjz.model.OwnerAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class houselistController {

    @Autowired
    private houseMapper houseMapper;

    @Autowired
    private ownerAccountMapper ownerAccountMapper;

    /*
        查找语句：get请求
        修改语句：put请求
        添加语句：Post请求
        删除语句：delete请求
    */

    @GetMapping("/emps")
    public String houselist(Model model, HttpSession session){
        String phonenum = (String)session.getAttribute("loginUser");
        OwnerAccount ownerAccount = ownerAccountMapper.select(phonenum);
        List<House> houselists = houseMapper.findHouseList(ownerAccount.getOwner_identitynum());
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
                         @RequestParam("Identitynum") String Identitynum){
        House house = new House(Address,Monthlyrent,Detail,Area,Use,Type,Floor,Decoration,Identitynum);
        house.setHouse_id(id);
        System.out.println("待修改的房子信息：" + house);
        System.out.println("将要修改了一个房源信息：" + house);
        houseMapper.updateHouse(house);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deletehouse(@PathVariable("id") Integer id){
        System.out.println("将要删除了一个房源信息，房子id为：" + id);
        houseMapper.deleteid(id);
        return "redirect:/emps";
    }

    @PostMapping("/emp")
    public String addHouse(@RequestParam("Address") String Address, @RequestParam("Monthlyrent") Integer Monthlyrent,
                           @RequestParam("Detail") String Detail, @RequestParam("Area") Integer Area,
                           @RequestParam("Use") String Use, @RequestParam("Type") String Type,
                           @RequestParam("Floor") Integer Floor,@RequestParam("Decoration") String Decoration,
                           @RequestParam("Identitynum") String Identitynum){
        House house = new House(Address,Monthlyrent,Detail,Area,Use,Type,Floor,Decoration,Identitynum);
        System.out.println("将要添加了一个房源信息：" + house);
        houseMapper.addhouse(house);
        return "redirect:/emps";
    }
}
