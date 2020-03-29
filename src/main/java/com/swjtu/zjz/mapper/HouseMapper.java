package com.swjtu.zjz.mapper;

import com.swjtu.zjz.bean.House;
import org.apache.ibatis.annotations.*;
import org.omg.CORBA.INTERNAL;

import java.util.List;

@Mapper
public interface HouseMapper {

    @Delete("delete from house where house_id = #{house_id}")
    void deleteid(Integer house_id);

    @Insert("insert into house (house_address,house_monthlyrent,house_detail,house_area) " +
            "values (#{house_address},#{house_monthlyrent},#{house_detail},#{house_area})")
    void addhouse(House house);

    @Select("select * from house")
    List<House> findHouseList();

    @Select("select * from house where house_id = #{houseId}")
    House findHouse(Integer houseId);

    @Update("update house set house_address = #{house_address},house_monthlyrent = #{house_monthlyrent}," +
            "house_detail = #{house_detail},house_area = #{house_area} where house_id = #{house_id}")
    void updateHouse(House house);
}
