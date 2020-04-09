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

    @Select("select * from house where owner_id = #{owner_id}")
    List<House> findHouseList(Integer owner_id);

    @Select("select * from house where house_id = #{houseId}")
    House findHouse(Integer houseId);


    @Update("update house set house_address = #{house_address},house_monthlyrent = #{house_monthlyrent},house_detail = #{house_detail},house_area = #{house_area}," +
            "house_use = #{house_use}, house_type = #{house_type}, house_floor = #{house_floor},house_decoration = #{house_decoration},rent_time = #{rent_time} " +
            "where house_id = #{house_id}")
    void updateHouse(House house);

    //查找所有未被租赁的房屋信息
    @Select("select * from house where rental_situation = '0'")
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

    @Update("update house set house_apply = #{house_apply} where house_id = #{house_id}")
    void updateHouseapply(char house_apply,Integer house_id);

    //查找用户申请的房屋信息
    @Select("select * from house where owner_identitynum = #{owner_identitynum} and house_apply = '1'")
    List<House> getApplyhouseList(String owner_identitynum);

}
