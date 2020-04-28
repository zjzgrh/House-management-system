package com.swjtu.zjz.controller;

import com.swjtu.zjz.dao.houseMapper;
import com.swjtu.zjz.dao.housecontractMapper;
import com.swjtu.zjz.dao.joinMapper;
import com.swjtu.zjz.model.House;
import com.swjtu.zjz.model.HouseContract;
import com.swjtu.zjz.model.TableAll;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class housecontratController {

    @Autowired
    private housecontractMapper housecontractMapper;

    @Autowired
    private joinMapper joinMapper;

    @Autowired
    private houseMapper houseMapper;

    //房主界面，点击合同查看展示该房主的合同信息
    @GetMapping("/showhousecontract")
    public String housecontratlist(HttpSession session, Model model) {
        List<TableAll> contractlists = joinMapper.getOwnerContract((Integer) session.getAttribute("userId"));
        //List<HouseContract> contractlists = housecontractMapper.getHouseContract((Integer) session.getAttribute("userId"));
        model.addAttribute("contractlists", contractlists);
        return "contract/showcontract";
    }

    //跳转到修改合同界面
    @GetMapping("/toupdatehousecontrat")
    public String toupdatecontract(Integer owner_id, Integer tenant_id, Integer house_id, Date contract_startdate, Model model){
        HouseContract houseContract = housecontractMapper.getHouseContract(owner_id, tenant_id, house_id, contract_startdate);
        House house = houseMapper.findHouse(house_id);
        model.addAttribute("house", house);
        model.addAttribute("houseContract", houseContract);
        return "contract/updatecontract";
    }

    @PutMapping("/updatehousecontrat")
    public String updatecontract(Integer owner_id, Integer tenant_id, Integer house_id, HttpSession session, Model model,
                                 @RequestParam("rent_time") Integer rent_time){

        houseMapper.updateHouseRenttime(rent_time,house_id);
        return "redirect:/showhousecontract";
    }

    //房客界面，点击和合同查看展示该房客的合同信息
    @GetMapping("/showtenantcontract")
    public String getTenantContract(HttpSession session, Model model) {
        List<TableAll> contractlists = joinMapper.getTenantContract((Integer) session.getAttribute("userId"));
        //List<HouseContract> contractlists = housecontractMapper.getHouseContract((Integer) session.getAttribute("userId"));
        model.addAttribute("contractlists", contractlists);
        return "contract/showtenantcontract";
    }
}
