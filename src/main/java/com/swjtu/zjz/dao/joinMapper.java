package com.swjtu.zjz.dao;

import com.swjtu.zjz.model.House;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface joinMapper {

    //    SELECT 列名1,列名2... FROM 表1 INNER JOIN 表2 ON 表1.外键=表2.主键 WhERE 条件语句;
    @Select("select house.house_id,house_address,house_monthlyrent,house_detail,house_area,house_use,house_type,house_floor,house_decoration,rent_time,apply_situation,rental_situation" +
            " from house inner join house_apply on house.house_id = house_apply.house_id where house_apply.tenant_id = #{id}")
    List<House> getTenantApplyHouse(Integer id);

    @Select("select house.house_id,house_address,house_monthlyrent,house_detail,house_area,house_use,house_type,house_floor,house_decoration,rent_time,apply_situation,rental_situation" +
            " from house inner join house_apply on house.house_id = house_apply.house_id where house.owner_id = #{id}")
    List<House> getOwnerApplyHouse(Integer id);


//    List<House> getApplyHouse(String house_address,Integer house_monthlyrent,String house_detail,Integer house_area,String house_use,
//                              String house_type,Integer house_floor,String house_decoration,Integer rent_time,Integer id);
}
