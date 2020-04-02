package com.swjtu.zjz.dao;

import com.swjtu.zjz.model.House;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface houseMapper {

    @Delete("delete from house where house_id = #{house_id}")
    void deleteid(Integer house_id);

    @Insert("insert into house (house_address,house_monthlyrent,house_detail,house_area,house_use,house_type," +
            "house_floor,house_decoration,owner_identitynum,rental_situation) " +
            "values " +
            "(#{house_address},#{house_monthlyrent},#{house_detail},#{house_area},#{house_use},#{house_type}," +
            "#{house_floor},#{house_decoration},#{owner_identitynum},#{rental_situation})")
    void addhouse(House house);

    @Select("select * from house")
    List<House> findHouseList();

    @Select("select * from house where house_id = #{houseId}")
    House findHouse(Integer houseId);

    @Update("update house set house_address = #{house_address},house_monthlyrent = #{house_monthlyrent},house_detail = #{house_detail}," +
            "house_area = #{house_area},house_use = #{house_use}, house_type = #{house_type}, house_floor = #{house_floor}," +
            "house_decoration = #{house_decoration},owner_identitynum = #{owner_identitynum},rental_situation = #{rental_situation}" +
            "where " +
            "house_id = #{house_id}")
    void updateHouse(House house);
}
