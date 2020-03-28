package com.swjtu.zjz.mapper;

import com.swjtu.zjz.bean.House;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.omg.CORBA.INTERNAL;

import java.util.List;

@Mapper
public interface HouseMapper {

    @Select("select * from house")
    List<House> findHouseList();

    @Select("select * from house where house_id = #{houseId}")
    House findHouse(Integer houseId);
}
