package com.swjtu.zjz.dao;

import com.swjtu.zjz.model.House;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface houseMapper {

    @Delete("delete from house where house_id = #{house_id}")
    void deleteid(Integer house_id);

    @Insert("insert into house (house_address,house_monthlyrent,house_detail,house_area,house_use,house_type,house_floor,house_decoration,rent_time,owner_id) "
            + "values (#{house_address},#{house_monthlyrent},#{house_detail},#{house_area},#{house_use},#{house_type},#{house_floor},#{house_decoration}," +
            "#{rent_time},#{owner_id})")
    void addhouse(House house);

    //查询未发布的房源信息
    @Select("select * from house where owner_id = #{owner_id} and post_status = '0'")
    List<House> findHouseList(Integer owner_id);

    //查询已发布房源信息列表
    @Select("select * from house where owner_id = #{owner_id} and post_status = '1'")
    List<House> findPublishHouseList(Integer owner_id);

    //删除已发布房源信息列表
    @Update("update house set post_status = '0' where house_id = #{house_id}")
    void deletePublishHouse(Integer house_id);

    //发布某房子
    @Update("update house set post_status = '1' where house_id = #{house_id}")
    void publishHouse(Integer house_id);


    @Select("select * from house where house_id = #{houseId}")
    House findHouse(Integer houseId);

    //找到房子的租赁状态
    @Select("select rental_situation from house where house_id = #{house_id}")
    Character getHouseRentalSituation(Integer house_id);

    @Update("update house set house_address = #{house_address},house_monthlyrent = #{house_monthlyrent},house_detail = #{house_detail},house_area = #{house_area}," +
            "house_use = #{house_use}, house_type = #{house_type}, house_floor = #{house_floor},house_decoration = #{house_decoration},rent_time = #{rent_time} " +
            "where house_id = #{house_id}")
    void updateHouse(House house);

    //查找所有未被租赁的房屋信息
    @Select("select * from house where rental_situation = '0' and post_status = '1'")
    List<House> findRenthouseList();

    //查找所有用户申请的房屋信息
    @Select("select * from house where house_apply = '1'")
    List<House> findApplyhouseList();

    @Select("select rental_situation from house where house_id = #{house_id}")
    char getRentalsituation(Integer house_id);

    @Update("update house set rental_situation = #{rental_situation} where house_id = #{house_id}" )
    void updateRentalsituation(char rental_situation,Integer house_id);

    @Select("select house_apply from house where house_id = #{house_id}")
    char getHouseapply(Integer house_id);

    //更改房子的租赁状态
    @Update("update house set apply_situation = #{apply_situation} where house_id = #{house_id}")
    void updateHouseApplySituation(char apply_situation,Integer house_id);

    //查找用户申请的房屋信息
    @Select("select * from house where owner_identitynum = #{owner_identitynum} and house_apply = '1'")
    List<House> getApplyhouseList(String owner_identitynum);

    //更改房子的租期
    @Update("update house set rent_time = #{rent_time} where house_id = #{house_id}")
    void updateHouseRenttime(Integer rent_time, Integer house_id);

    //查找房子的租期
    @Select("select rent_time from house where house_id = #{house_id}")
    Integer getHouseRenttime(Integer house_id);
}
