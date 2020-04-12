package com.swjtu.zjz.controller;

import com.swjtu.zjz.dao.houseMapper;
import com.swjtu.zjz.dao.joinMapper;
import com.swjtu.zjz.model.House;
import com.swjtu.zjz.model.OwnerAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class rentController {

    @Autowired
    private houseMapper houseMapper;

    @Autowired
    private joinMapper joinMapper;

    //房主查看房屋租赁申请请求，
    @GetMapping("/houseapply")
    public String houseapplylist(HttpSession session, Model model){
        List<House> houselists = joinMapper.getOwnerApplyHouse((Integer) session.getAttribute("userId"));
        System.out.println(houselists);
        model.addAttribute("houselists", houselists);
        return "rentmanage/houseapplylist";
    }

}
