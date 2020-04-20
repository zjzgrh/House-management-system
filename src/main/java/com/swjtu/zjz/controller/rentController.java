package com.swjtu.zjz.controller;

import com.swjtu.zjz.dao.houseMapper;
import com.swjtu.zjz.dao.joinMapper;
import com.swjtu.zjz.dao.rentMapper;
import com.swjtu.zjz.model.House;
import com.swjtu.zjz.model.HouseApply;
import com.swjtu.zjz.model.Rent;
import com.swjtu.zjz.model.TableAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class rentController {

    @Autowired
    private houseMapper houseMapper;

    @Autowired
    private joinMapper joinMapper;

    @Autowired
    private rentMapper rentMapper;

    //房主查看房屋租赁申请请求，查找申请表中房主用户拥有的房子的申请记录，需要知道每条记录的申请房客的id及name
    @GetMapping("/houseapply")
    public String houseapplylist(HttpSession session, Model model){
        //List<House> houselists = joinMapper.getOwnerApplyHouse((Integer) session.getAttribute("userId"));
        List<TableAll> applylists = joinMapper.getOwnerApply((Integer) session.getAttribute("userId"));
        System.out.println("瞅瞅这里的信息对不对，这里是查出来的申请表的信息：" + applylists);
        //model.addAttribute("houselists", houselists);
        model.addAttribute("applylists", applylists);
        return "rentmanage/houseapplylist";
    }

    @GetMapping("/confirmrent")
    public String renthouse( Integer house_id,Integer tenant_id,Model model,HttpSession session){
        houseMapper.updateRentalsituation('1',house_id);
        System.out.println("这里是两个ID：" + tenant_id + "   " +  house_id);
        Rent rent = new Rent((Integer) session.getAttribute("userId"),tenant_id,house_id,new Date());
        System.out.println("传到数据库中的租赁表中的数据：" + rent);
        rentMapper.addHouseRent(rent);
        return "redirect:/houseapply";
    }

    @GetMapping("/rentmanage")
    public String rentmanagelist(HttpSession session, Model model){
        List<Rent> rentlists = rentMapper.getRentHouselists((Integer) session.getAttribute("userId"));
        model.addAttribute("rentlists", rentlists);
        return "rentmanage/rentmanagelist";
    }

}
