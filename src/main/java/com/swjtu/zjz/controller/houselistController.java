package com.swjtu.zjz.controller;

import com.swjtu.zjz.bean.House;
import com.swjtu.zjz.bean.OwnerAccount;
import com.swjtu.zjz.mapper.HouseMapper;
import com.swjtu.zjz.mapper.OwnerAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
