/*
package com.swjtu.zjz.controller;

import com.swjtu.zjz.dao.houseMapper;
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
    private ownerAccountMapper ownerAccountMapper;

    @Autowired
    private houseMapper houseMapper;

    @GetMapping("/houseapply")
    public String houseapplylist(HttpSession session, Model model){
        OwnerAccount houseOwner = ownerAccountMapper.select((String) session.getAttribute("loginUser"));
        System.out.println(" 看看查出了什么东西，有没有身份证号 ：" + houseOwner);
        List<House> houseList = houseMapper.getApplyhouseList(houseOwner.getOwner_identitynum());
        System.out.println("看看这个列表是什么东西：" + houseList);
        model.addAttribute("houselists", houseList);
        return "rentmanage/houseapplylist";
    }

}
*/
