package com.swjtu.zjz.dao;

import com.swjtu.zjz.model.HouseComment;
import com.swjtu.zjz.model.TableAll;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

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

    //查找评论内容
    @Select("select comment_detail from house_comment where tenant_id = #{tenant_id} and house_id = #{house_id}")
    String findCommentDetail(Integer tenant_id, Integer house_id);

    //查找某房子额所有的评价
    @Select("select * from house_comment,house_tenant where house_comment.tenant_id = house_tenant.tenant_id and house_comment.house_id = #{house_id}")
    List<TableAll> getcommentlist(Integer house_id);

}
