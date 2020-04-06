package com.swjtu.zjz.controller;

import com.swjtu.zjz.dao.houseMapper;
import com.swjtu.zjz.dao.ownerAccountMapper;
import com.swjtu.zjz.model.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class renthouseController {

    @Autowired
    private houseMapper houseMapper;

    @Autowired
    private ownerAccountMapper ownerAccountMapper;

    @GetMapping("/renthouselist")
    public String showRenthouseList(Model model){
        List<House> houselists = houseMapper.findRenthouseList();
        model.addAttribute("houselists", houselists);
        return "renthouse/renthouselist";
    }

    @GetMapping("/apply/{id}")
    public String applyhouse(@PathVariable("id") Integer id, Model model){
        houseMapper.updateHouseapply('1',id);
        return "redirect:/renthouselist";
    }

    @GetMapping("/cancelapply/{id}")
    public String cancelapply(@PathVariable("id") Integer id, Model model){
        houseMapper.updateHouseapply('0',id);
        return "redirect:/applyhouselist";
    }

    @GetMapping("/applyhouselist")
    public String showApplyhouseList(Model model){
        List<House> houselists = houseMapper.findApplyhouseList();
        model.addAttribute("houselists", houselists);
        return "renthouse/applyhouselist";
    }
}
