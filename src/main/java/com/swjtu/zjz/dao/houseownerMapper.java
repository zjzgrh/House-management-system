package com.swjtu.zjz.dao;

import com.swjtu.zjz.model.HouseOwner;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface houseownerMapper {
    @Insert("insert into house_owner (owner_identitynum,owner_name,owner_sex,owner_age,phonenum) " +
            "values (#{owner_identitynum},#{owner_name},#{owner_sex},#{owner_age},#{phonenum})")
    void addhouseowner(HouseOwner houseOwner);

    @Select("select * from house_owner where phonenum = #{phonenum}")
    HouseOwner findHouseOwner(String phonenum);
}
