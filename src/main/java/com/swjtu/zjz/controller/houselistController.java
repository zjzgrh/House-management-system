package com.swjtu.zjz.controller;

import com.swjtu.zjz.bean.House;
import com.swjtu.zjz.mapper.HouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class houselistController {

    @Autowired
    private HouseMapper houseMapper;

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
    public String toUpdate(@PathVariable("id") Integer id,
                            Model model){
        House house = houseMapper.findHouse(id);
        System.out.println(house);
        model.addAttribute("house", house);
        return "emp/addhouse";
    }

    @PutMapping("/emp")
    public String update(@RequestParam("id") Integer id,
                         @RequestParam("Address") String Address,
                         @RequestParam("Monthlyrent") Integer Monthlyrent,
                         @RequestParam("Detail") String Detail,
                         @RequestParam("Area") Integer Area){
        House house = new House(Address,Monthlyrent,Detail,Area);
        house.setHouse_id(id);
        System.out.println(house);
        houseMapper.updateHouse(house);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deletehouse(@PathVariable("id") Integer id){
        houseMapper.deleteid(id);
        return "redirect:/emps";
    }
}
