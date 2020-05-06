package com.swjtu.zjz.controller;

import com.swjtu.zjz.dao.houseMapper;
import com.swjtu.zjz.dao.houseownerMapper;
import com.swjtu.zjz.model.House;
import com.swjtu.zjz.model.HouseOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class houselistController {

    @Autowired
    private houseMapper houseMapper;

    @Autowired
    private houseownerMapper houseownerMapper;


    /*
        查找语句：get请求
        修改语句：put请求
        添加语句：Post请求
        删除语句：delete请求
    */

    //显示房主 持有的所有的房子
    @GetMapping("/emps")
    public String houselist(Model model, HttpSession session){
        HouseOwner houseOwner = houseownerMapper.findOwnerid((Integer) session.getAttribute("userId"));
        System.out.println(session.getAttribute("userId"));
        List<House> houselists = houseMapper.findHouseList(houseOwner.getOwner_id());
        model.addAttribute("houselists", houselists);
        System.out.println(houselists);
        return "emp/houselist";
    }

    //点击首页的已发布房源  --->  后台查询数据库已发布房源信息 --> 跳转进入已发布房源界面
    @GetMapping("/published")
    public String publishedhouselist(Model model, HttpSession session){
        List<House> publishhouselists = houseMapper.findPublishHouseList((Integer) session.getAttribute("userId"));
        model.addAttribute("publishhouselists", publishhouselists);
        System.out.println("已发布房源: " + publishhouselists);
        return "emp/publishedhouselist";
    }

    //取消发布某房子
    @GetMapping("/unpublish/{id}")
    public String unpublishhouse(@PathVariable("id") Integer id, Model model, HttpSession session){
        houseMapper.deletePublishHouse(id);
        return "redirect:/published";
    }

    //发布某房子
    @GetMapping("/publish/{id}")
    public String publishhouse(@PathVariable("id") Integer id, Model model, HttpSession session){
        houseMapper.publishHouse(id);
        return "redirect:/published";
    }

/*//没有实名注册时，先跳转界面进行实名注册
        if(houseOwner.getOwner_identitynum() == null){
            model.addAttribute("realname", "请先进行实名注册再进行其他操作！");
            return "/owners";
        }else{
        //已经进行实名注册就可以进行房源的添加
            List<House> houselists = houseMapper.findHouseList(houseOwner.getOwner_id());
            model.addAttribute("houselists", houselists);
            return "emp/houselist";
        }*/

    //跳转到房源添加页面
    @GetMapping("/emp")
    public String addhouse(Model model,HttpSession session){
        HouseOwner houseOwner = houseownerMapper.findOwnerid((Integer) session.getAttribute("userId"));
        if(houseOwner.getOwner_identitynum() == null){
            model.addAttribute("realname", "请先进行实名注册再进行房源发布！");
            System.out.println("请先进行实名注册再进行房源发布");
            //由于没有进行实名注册，直接跳转到实名注册界面
            return "owner/addhouseowner";
        }else{
            //已经进行实名注册就可以进行房源的添加
            return "emp/addhouse";
        }
    }

    //跳转到房子修改的页面，将当前房源信息传递到房源修改界面
    @GetMapping("/emp/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model){
        House house = houseMapper.findHouse(id);
        model.addAttribute("house", house);
        return "emp/addhouse";
    }

    //房源信息修改，回去界面的数据进行修改
    @PutMapping("/emp")
    public String update(@RequestParam("id") Integer id,
                         @RequestParam("Address") String Address, @RequestParam("Monthlyrent") Integer Monthlyrent,
                         @RequestParam("Detail") String Detail, @RequestParam("Area") Integer Area,
                         @RequestParam("Use") String Use, @RequestParam("Type") String Type,
                         @RequestParam("Floor") Integer Floor,@RequestParam("Decoration") String Decoration,
                         @RequestParam("Renttime") Integer Renttime){

        House house = new House(Address, Monthlyrent, Decoration, Area, Use, Type, Floor, Decoration, Renttime);
        house.setHouse_id(id);
        System.out.println(house);
        houseMapper.updateHouse(house);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deletehouse(@PathVariable("id") Integer id){
        System.out.println("将要删除了一个房源信息，房子id为：" + id);
        houseMapper.deleteid(id);
        return "redirect:/emps";
    }

    @PostMapping("/emp")
    public String addHouse(@RequestParam("Address") String Address, @RequestParam("Monthlyrent") Integer Monthlyrent,
                           @RequestParam("Detail") String Detail, @RequestParam("Area") Integer Area,
                           @RequestParam("Use") String Use, @RequestParam("Type") String Type,
                           @RequestParam("Floor") Integer Floor,@RequestParam("Decoration") String Decoration,
                           @RequestParam("Renttime") Integer Renttime,HttpSession session){
        House house = new House(Address,Monthlyrent,Detail,Area,Use,Type,Floor,Decoration,Renttime);
        house.setOwner_id((Integer) session.getAttribute("userId"));
        System.out.println("将要添加了一个房源信息：" + house);
        houseMapper.addhouse(house);
        return "redirect:/emps";
    }
}
