package com.swjtu.zjz.controller;

import com.swjtu.zjz.dao.houseMapper;
import com.swjtu.zjz.dao.houseapplyMapper;
import com.swjtu.zjz.dao.houseownerMapper;
import com.swjtu.zjz.dao.joinMapper;
import com.swjtu.zjz.model.House;
import com.swjtu.zjz.model.HouseApply;
import com.swjtu.zjz.model.TableAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.net.Inet4Address;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class renthouseController {

    @Autowired
    private joinMapper joinMapper;

    @Autowired
    private houseMapper houseMapper;

    @Autowired
    private houseapplyMapper houseapplyMapper;

    @GetMapping("/renthouselist")
    public String showRenthouseList(Model model,HttpSession session){
        List<House> houselists = houseMapper.findRenthouseList();
        for (House houselist : houselists){
            if(houseapplyMapper.judgeApplyStatus(houselist.getHouse_id(),(Integer) session.getAttribute("userId")) == null)
            {
                houseMapper.updateHouseapply('0',houselist.getHouse_id());
                houselist.setApply_situation('0');
            } else{
                houseMapper.updateHouseapply('1',houselist.getHouse_id());
                houselist.setApply_situation('1');
            }
        }
        model.addAttribute("houselists", houselists);
        System.out.println(houselists);
        return "renthouse/renthouselist";
    }

    //在房源界面，点击申请按钮，把房子表中申请状态置为1，然后将该申请内容写入申请表。
    @GetMapping("/apply/{id}")
    public String applyhouse(@PathVariable("id") Integer id, HttpSession session,Model model){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        HouseApply houseApply = new HouseApply((Integer) session.getAttribute("userId"), id, date);
        houseapplyMapper.addHouseApplly(houseApply);
        return "redirect:/renthouselist";
    }

    //在房子申请界面，点击取消申请时，将该房子的申请状态置为0，并在申请表中删除该申请信息
    @GetMapping("/cancelapply/{id}")
    public String cancelapply(@PathVariable("id") Integer id, Model model){

        houseapplyMapper.deleteApplyHouseId(id);
        return "redirect:/applyhouselist";
    }

    //首页点击租房申请时，查询查询申请表中的当前房客号对应的房子列表，并跳转到房子申请表界面
    @GetMapping("/applyhouselist")
    public String showApplyhouseList(Model model,HttpSession session){
//        List<House> houselists = houseapplyMapper.getApplyHouselists((Integer) session.getAttribute("userId"));
        List<TableAll> houselists = joinMapper.getTenantApplyHouse((Integer) session.getAttribute("userId"));
        System.out.println("房客这里的申请表情况：" + houselists);
        model.addAttribute("houselists", houselists);
        return "renthouse/applyhouselist";
    }


}
