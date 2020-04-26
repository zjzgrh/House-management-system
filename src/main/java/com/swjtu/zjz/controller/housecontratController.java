package com.swjtu.zjz.controller;

import com.swjtu.zjz.dao.houseMapper;
import com.swjtu.zjz.dao.housecontractMapper;
import com.swjtu.zjz.dao.joinMapper;
import com.swjtu.zjz.model.HouseContract;
import com.swjtu.zjz.model.TableAll;
import net.bytebuddy.asm.Advice;
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

    @Autowired
    private joinMapper joinMapper;

    @GetMapping("/showhousecontract")
    public String housecontratlist(HttpSession session, Model model) {
        List<TableAll> contractlists = joinMapper.getOwnerContract((Integer) session.getAttribute("userId"));
        //List<HouseContract> contractlists = housecontractMapper.getHouseContract((Integer) session.getAttribute("userId"));
        model.addAttribute("contractlists", contractlists);
        return "contract/showcontract";
    }

    @GetMapping("/updatehousecontrat")
    public String toupdatecontractlist(Integer owner_id,Integer tenant_id,Integer house_id, HttpSession session,Model model){

        return "";
    }
}
