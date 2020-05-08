package com.swjtu.zjz.dao;

import com.swjtu.zjz.model.House;
import com.swjtu.zjz.model.TableAll;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface joinMapper {

    //    SELECT 列名1,列名2... FROM 表1 INNER JOIN 表2 ON 表1.外键=表2.主键 WhERE 条件语句;
    @Select("select house.house_id,house_address,house_monthlyrent,house_detail,house_area,house_use,house_type,house_floor,house_decoration,rent_time,apply_situation,rental_situation,apply_result" +
            " from house inner join house_apply on house.house_id = house_apply.house_id where house_apply.tenant_id = #{id}")
    List<TableAll> getTenantApplyHouse(Integer id);

    @Select("select house.house_id,house_address,house_monthlyrent,house_detail,house_area,house_use,house_type,house_floor,house_decoration,rent_time,apply_situation,rental_situation,apply_result" +
            " from house inner join house_apply on house.house_id = house_apply.house_id where house.owner_id = #{id}")
    List<House> getOwnerApplyHouse(Integer id);

    //目的是查询申请表中，某房主，拥有的所有的房子的申请
    @Select("select house.house_id,house_tenant.tenant_id,house_tenant.tenant_name,house_address,house_monthlyrent,house_detail,house_area,house_use,apply_result," +
            "house_type,house_floor,house_decoration,house.rent_time,rental_situation,house_apply.apply_starttime" +
            " from house_tenant,house_apply,house " +
            "where house_tenant.tenant_id = house_apply.tenant_id and house_apply.house_id = house.house_id and house.owner_id = #{id}")
    List<TableAll> getOwnerApply(Integer id);

    //目的是查询租赁表中，某房主，拥有的所有的租赁的房子
    @Select("select house.house_id,house_tenant.tenant_id,house_owner.owner_name,house_tenant.tenant_name,house_address,house_monthlyrent," +
            "house_detail,house_area,house_use, house_type,house_floor,house_decoration,house.rent_time,rental_situation,rent_starttime" +
            " from house_tenant,rent,house,house_owner " +
            "where house_tenant.tenant_id = rent.tenant_id and rent.house_id = house.house_id and rent.owner_id = house_owner.owner_id and " +
            "house_owner.owner_id = #{id}")
    List<TableAll> getOwnerRent(Integer id);

    //目的是查询租赁表中，某房客，拥有的所有的租赁的房子
    @Select("select house.house_id,house_tenant.tenant_id,house_owner.owner_name,house_tenant.tenant_name,house_address,house_monthlyrent," +
            "house_detail,house_area,house_use, house_type,house_floor,house_decoration,house.rent_time,rental_situation,rent_starttime" +
            " from house_tenant,rent,house,house_owner " +
            "where house_tenant.tenant_id = rent.tenant_id and rent.house_id = house.house_id and rent.owner_id = house_owner.owner_id and " +
            "house_tenant.tenant_id = #{id}")
    List<TableAll> getTenantRent(Integer id);

    //目的是查询合同表中，某房主，拥有的所有的租赁的房子的合同情况
    @Select("select house.house_id,house_tenant.tenant_id,house_owner.owner_name,house_tenant.tenant_name,house_address,house_monthlyrent," +
            "house_detail,house_area,house_use, house_type,house_floor,house_decoration,house.rent_time,rental_situation,contract_startdate,contract_enddate " +
            "from house_tenant,house_contract,house,house_owner " +
            "where house_tenant.tenant_id = house_contract.tenant_id and house_contract.house_id = house.house_id and house_contract.owner_id = house_owner.owner_id and " +
            "house_owner.owner_id = #{id}")
    List<TableAll> getOwnerContract(Integer id);

    //目的是查询合同表中，某房客，拥有的所有的租赁的房子的合同情况
    @Select("select house.house_id,house_tenant.tenant_id,house_owner.owner_name,house_tenant.tenant_name,house_address,house_monthlyrent," +
            "house_detail,house_area,house_use, house_type,house_floor,house_decoration,house.rent_time,rental_situation,contract_startdate,contract_enddate " +
            "from house_tenant,house_contract,house,house_owner " +
            "where house_tenant.tenant_id = house_contract.tenant_id and house_contract.house_id = house.house_id and house_contract.owner_id = house_owner.owner_id and " +
            "house_tenant.tenant_id = #{id}")
    List<TableAll> getTenantContract(Integer id);

    @Select("select house.house_id,house_address,house_monthlyrent,house_detail,house_area,house_use,house_type,house_floor,house_decoration,rent_time,apply_situation,rental_situation" +
            " from house inner join house_apply on house.house_id = house_apply.house_id where house.owner_id = #{id}")
    List<House> getOwnerRentHouse(Integer id);

    @Select("select house.house_id,house_address,house_monthlyrent,house_detail,house_area,house_use,house_type,house_floor,house_decoration,rent_time,apply_situation,rental_situation" +
            " from house inner join house_apply on house.house_id = house_apply.house_id where house.owner_id = #{id}")
    List<House> getTenantRentHouse(Integer id);

//    List<House> getApplyHouse(String house_address,Integer house_monthlyrent,String house_detail,Integer house_area,String house_use,
//                              String house_type,Integer house_floor,String house_decoration,Integer rent_time,Integer id);
}
