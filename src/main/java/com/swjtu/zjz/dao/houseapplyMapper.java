package com.swjtu.zjz.dao;

import com.swjtu.zjz.model.House;
import com.swjtu.zjz.model.HouseApply;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface houseapplyMapper {

    @Insert("insert into house_apply (house_id,tenant_id,apply_starttime) values (#{house_id},#{tenant_id},#{apply_starttime})")
    void addHouseApplly(HouseApply houseApply);

    @Select("select * from house_apply where tenant_id = #{id}")
    List<House> getApplyHouselists(Integer id);

    @Delete("delete from house_apply where house_id = #{house_id}")
    void deleteApplyHouseId(Integer house_id);
}
