package com.swjtu.zjz.controller;

import com.swjtu.zjz.dao.*;
import com.swjtu.zjz.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
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

    @Autowired
    private housecontractMapper housecontractMapper;

    @Autowired
    private houseapplyMapper houseapplyMapper;



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

    //在房主系统，房子申请页面，点击同意时，将该房子添加到租赁表和合同表,把申请结果设置为1，显示为申请成功
    @GetMapping("/confirmrent")
    public String renthouse( Integer house_id,Integer tenant_id,Model model,HttpSession session){
        //将申请表中的申请结果设置为1
        houseapplyMapper.setApplyResultTrue(house_id,tenant_id);

        //房子的租赁状态设置为1，将房主房客房子三方添加到租赁表中
        houseMapper.updateRentalsituation('1',house_id);
        System.out.println("这里是两个ID：" + tenant_id + "   " +  house_id);
        Rent rent = new Rent((Integer) session.getAttribute("userId"),tenant_id,house_id,new Date());
        System.out.println("传到数据库中的租赁表中的数据：" + rent);
        rentMapper.addHouseRent(rent);
        //这里将房主房客房子三方添加到合同表中
        HouseContract houseContract = new HouseContract((Integer) session.getAttribute("userId"), tenant_id, house_id, new Date());
        //查一下房子的租期，存到合同信息里面
        int month = houseMapper.findHouse(house_id).getRent_time();
        model.addAttribute("renttime", month);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH,month);
        Date endtime = calendar.getTime();
        houseContract.setContract_enddate(endtime);
        housecontractMapper.addHouseContract(houseContract);


        return "redirect:/houseapply";
    }

    //在房主系统，房子申请页面，点击拒绝时，把申请结果设置为0，显示为申请失败
    @GetMapping("/refuserent")
    public String denyrenthouse( Integer house_id,Integer tenant_id,Model model,HttpSession session){
        //将申请表中的申请结果设置为0
        houseapplyMapper.setApplyResultFalse(house_id,tenant_id);
        return "redirect:/houseapply";
    }

    @GetMapping("/rentmanage")
    public String rentmanagelist(HttpSession session, Model model){
        //List<Rent> rentlists = rentMapper.getRentHouselists((Integer) session.getAttribute("userId"));
        List<TableAll> rentlists = joinMapper.getOwnerRent((Integer) session.getAttribute("userId"));
        model.addAttribute("rentlists", rentlists);
        return "rentmanage/rentmanagelist";
    }

    //在房客界面，点击房屋租赁时，显示该房客租赁的所有的房屋信息
    @GetMapping("/rentlist")
    public String showRentList(HttpSession session, Model model){
        List<TableAll> rentlists = joinMapper.getTenantRent((Integer) session.getAttribute("userId"));
        model.addAttribute("rentlists", rentlists);
        return "renthouse/rentlist";
    }

}
