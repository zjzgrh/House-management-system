package com.swjtu.zjz.controller;

import com.swjtu.zjz.dao.commentMapper;
import com.swjtu.zjz.model.HouseComment;
import com.swjtu.zjz.model.TableAll;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class commentController {

    @Autowired
    private commentMapper commentMapper;

    //跳转到评论界面
    @GetMapping("/tocomment")
    private String toComment(Integer tenant_id, Integer house_id, Model model) {
        HouseComment houseComment = new HouseComment(tenant_id, house_id);
        //commentMapper.addComment(houseComment);
        model.addAttribute("houseComment", houseComment);
        return "comment/housecomment";
    }

    @PostMapping("/publishcomment")
    private String housecomment(Integer tenant_id, Integer house_id, @RequestParam("comment") String comment) {
        Date date = new Date();
        HouseComment houseComment = new HouseComment(tenant_id, house_id, date);
        commentMapper.addComment(houseComment);
        commentMapper.updateComment(comment,tenant_id,house_id);
        return "renthouse/rentedlist";
    }

    @GetMapping("/cancelcomment")
    private String housecomment(Integer tenant_id, Integer house_id) {
        //commentMapper.deleteHouseComment(tenant_id,house_id);
        return "renthouse/rentedlist";
    }

    @GetMapping("/findcomment/{house_id}")
    private String findHouseComment(@PathVariable("house_id") Integer house_id,Model model){
        List<TableAll> commentlists = commentMapper.getcommentlist(house_id);
        model.addAttribute("commentlists", commentlists);
        return "comment/ahousecomment";
    }
}
