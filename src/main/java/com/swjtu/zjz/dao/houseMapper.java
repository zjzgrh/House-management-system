package com.swjtu.zjz.dao;

import com.swjtu.zjz.model.House;
import org.apache.ibatis.annotations.*;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

@Mapper
public interface houseMapper {

    @Delete("delete from house where house_id = #{house_id}")
    void deleteid(Integer house_id);

    @Insert("insert into house (house_address,house_monthlyrent,house_detail,house_area,house_use,house_type," +
            "house_floor,house_decoration,owner_identitynum) " +
            "values " +
            "(#{house_address},#{house_monthlyrent},#{house_detail},#{house_area},#{house_use},#{house_type}," +
            "#{house_floor},#{house_decoration},#{owner_identitynum})")
    void addhouse(House house);

    @Select("select * from house where owner_identitynum = #{owner_identitynum}")
    List<House> findHouseList(String owner_identitynum);

    @Select("select * from house where house_id = #{houseId}")
    House findHouse(Integer houseId);

    @Update("update house set house_address = #{house_address},house_monthlyrent = #{house_monthlyrent},house_detail = #{house_detail}," +
            "house_area = #{house_area},house_use = #{house_use}, house_type = #{house_type}, house_floor = #{house_floor}," +
            "house_decoration = #{house_decoration},owner_identitynum = #{owner_identitynum}" +
            "where " +
            "house_id = #{house_id}")
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

}
