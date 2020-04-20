package com.swjtu.zjz.dao;

import com.swjtu.zjz.model.House;
import com.swjtu.zjz.model.TableAll;
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

    //目的是查询申请表中，某房主，拥有的的所以的房子的申请
    @Select("select house.house_id,house_tenant.tenant_id,house_tenant.tenant_name,house_address,house_monthlyrent,house_detail,house_area,house_use,house_type,house_floor,house_decoration," +
            "house.rent_time,rental_situation,house_apply.apply_starttime" +
            " from house_tenant,house_apply,house " +
            "where house_tenant.tenant_id = house_apply.tenant_id and house_apply.house_id = house.house_id and house.owner_id = #{id}")
    List<TableAll> getOwnerApply(Integer id);

    @Select("select house.house_id,house_address,house_monthlyrent,house_detail,house_area,house_use,house_type,house_floor,house_decoration,rent_time,apply_situation,rental_situation" +
            " from house inner join house_apply on house.house_id = house_apply.house_id where house.owner_id = #{id}")
    List<House> getOwnerRentHouse(Integer id);

    @Select("select house.house_id,house_address,house_monthlyrent,house_detail,house_area,house_use,house_type,house_floor,house_decoration,rent_time,apply_situation,rental_situation" +
            " from house inner join house_apply on house.house_id = house_apply.house_id where house.owner_id = #{id}")
    List<House> getTenantRentHouse(Integer id);

//    List<House> getApplyHouse(String house_address,Integer house_monthlyrent,String house_detail,Integer house_area,String house_use,
//                              String house_type,Integer house_floor,String house_decoration,Integer rent_time,Integer id);
}
