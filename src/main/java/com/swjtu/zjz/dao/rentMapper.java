package com.swjtu.zjz.dao;

import com.swjtu.zjz.model.House;
import com.swjtu.zjz.model.HouseApply;
import com.swjtu.zjz.model.Rent;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface rentMapper {
    @Insert("insert into rent (owner_id,house_id,tenant_id,rent_starttime) values (#{owner_id},#{house_id},#{tenant_id},#{rent_starttime})")
    void addHouseRent(Rent rent);

    @Select("select * from rent where owner_id = #{id}")
    List<Rent> getRentHouselists(Integer id);

    /*@Delete("delete from house_apply where house_id = #{house_id}")
    void deleteApplyHouseId(Integer house_id);

    //判断房子申请状态
    @Select("select * from house_apply where house_id = #{house_id} and tenant_id  = #{tenant_id}")
    HouseApply judgeApplyStatus(Integer house_id,Integer tenant_id);*/
}
