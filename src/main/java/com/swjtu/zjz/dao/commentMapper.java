package com.swjtu.zjz.dao;

import com.swjtu.zjz.model.HouseComment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

@Mapper
public interface commentMapper {

    //添加数据，主要是用户id，房子id,评论时间
    @Insert("insert into house_comment (tenant_id,house_id,comment_time) values (#{tenant_id},#{house_id},#{comment_time})")
    void addComment(HouseComment houseComment);

    //在评论表中添加评论时间和评论内容
    @Update("update house_comment set comment_detail = #{comment_detail} where tenant_id = #{tenant_id} and house_id = #{house_id}")
    void updateComment(String comment_detail, Integer tenant_id, Integer house_id);

    @Delete("delete from house_comment where tenant_id = #{tenant_id} and house_id = #{house_id}")
    void deleteHouseComment(Integer tenant_id, Integer house_id);


}
