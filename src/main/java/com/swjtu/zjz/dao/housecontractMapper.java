package com.swjtu.zjz.dao;

import com.swjtu.zjz.model.HouseContract;
import com.swjtu.zjz.model.Rent;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface housecontractMapper {

    @Insert("insert into house_contract (owner_id,house_id,tenant_id,contract_startdate,contract_enddate) " +
            "values (#{owner_id},#{house_id},#{tenant_id},#{contract_startdate},#{contract_enddate})")
    void addHouseContract(HouseContract houseContract);

    @Select("select * from house_contract where owner_id = #{owner_id}")
    List<HouseContract> getHouseContract(Integer owner_id);

}
