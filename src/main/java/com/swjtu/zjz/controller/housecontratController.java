package com.swjtu.zjz.controller;

import com.swjtu.zjz.dao.housecontractMapper;
import com.swjtu.zjz.model.HouseContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class housecontratController {

    @Autowired
    private housecontractMapper housecontractMapper;

    @GetMapping("/showhousecontract")
    public String housecontratlist(HttpSession session, Model model) {
        List<HouseContract> contractlists = housecontractMapper.getHouseContract((Integer) session.getAttribute("userId"));
        model.addAttribute("contractlists", contractlists);
        return "contract/showcontract";
    }
}
