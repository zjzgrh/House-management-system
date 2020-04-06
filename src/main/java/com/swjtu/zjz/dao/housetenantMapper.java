package com.swjtu.zjz.dao;

import com.swjtu.zjz.model.HouseOwner;
import com.swjtu.zjz.model.HouseTenant;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface housetenantMapper {
    @Insert("insert into house_tenant (tenant_identitynum,tenant_name,tenant_sex,tenant_age) " +
            "values (#{tenant_identitynum},#{tenant_name},#{tenant_sex},#{tenant_age})")
    void addhousetenant(HouseTenant houseTenant);

    @Select("select * from house_tenant where tenant_identitynum = #{tenant_identitynum}")
    HouseTenant findHouseTenant(String tenant_identitynum);
}
