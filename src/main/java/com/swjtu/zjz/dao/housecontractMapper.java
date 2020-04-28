package com.swjtu.zjz.dao;

import com.swjtu.zjz.model.HouseContract;
import com.swjtu.zjz.model.Rent;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

@Mapper
public interface housecontractMapper {

    @Insert("insert into house_contract (owner_id,house_id,tenant_id,contract_startdate,contract_enddate) " +
            "values (#{owner_id},#{house_id},#{tenant_id},#{contract_startdate},#{contract_enddate})")
    void addHouseContract(HouseContract houseContract);

    @Select("select * from house_contract where owner_id = #{owner_id}")
    List<HouseContract> getHouseContractList(Integer owner_id);

    @Select("select * from house_contract where owner_id = #{owner_id} and tenant_id = #{tenant_id} and house_id = #{house_id} and contract_startdate = #{contract_startdate}")
    HouseContract getHouseContract(Integer owner_id, Integer tenant_id, Integer house_id, Date contract_startdate);
}
