package com.swjtu.zjz.controller;

import com.swjtu.zjz.dao.rentMapper;
import com.swjtu.zjz.model.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

public class housecontratController {

    @Autowired
    private rentMapper rentMapper;

    @GetMapping("/rentmanage")
    public String rentmanagelist(HttpSession session, Model model){
        List<Rent> rentlists = rentMapper.getRentHouselists((Integer) session.getAttribute("userId"));
        model.addAttribute("rentlists", rentlists);
        return "rentmanage/rentmanagelist";
    }
}
