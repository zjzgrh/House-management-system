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

    //点击确认，将评论写入评论表
    @PostMapping("/publishcomment")
    private String housecomment(Integer tenant_id, Integer house_id, @RequestParam("comment") String comment) {
        Date date = new Date();
        HouseComment houseComment = new HouseComment(tenant_id, house_id, date);
        System.out.println("这里是某房子的评论内容,接下来会将内容写入数据库：" + houseComment + comment);
        commentMapper.addComment(houseComment);
        commentMapper.updateComment(comment,tenant_id,house_id);
        return "redirect:/rentedlist";
    }

    //取消评论，就一个简单的界面跳转
    @GetMapping("/cancelcomment")
    private String housecomment(Integer tenant_id, Integer house_id) {
        //commentMapper.deleteHouseComment(tenant_id,house_id);
        return "renthouse/rentedlist";
    }

    //查看某房子的所有用户的评论内容
    @GetMapping("/findcomment/{house_id}")
    private String findHouseComment(@PathVariable("house_id") Integer house_id,Model model){
        List<TableAll> commentlists = commentMapper.getcommentlist(house_id);
        model.addAttribute("commentlists", commentlists);
        return "comment/ahousecomment";
    }
}
