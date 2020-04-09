package com.swjtu.zjz.dao;

import com.swjtu.zjz.model.HouseOwner;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface houseownerMapper {
    @Insert("insert into house_owner (owner_identitynum,owner_name,owner_sex,owner_age) " +
            "values (#{owner_identitynum},#{owner_name},#{owner_sex},#{owner_age})")
    void addhouseowner(HouseOwner houseOwner);

    @Select("select * from house_owner where owner_identitynum = #{owner_identitynum}")
    HouseOwner findHouseOwner(String owner_identitynum);

    //查询手机号来返回该手机号的账号对象
    @Select("select * from house_owner where phonenum = #{phonenum}")
    HouseOwner findPhonenum(String phonenum);

    //查询owner_id来返回该账号的对象
    @Select("select * from house_owner where owner_id = #{owner_id}")
    HouseOwner findOwnerid(Integer owner_id);

    //注册账号(手机号和密码)
    @Insert("insert into house_owner (phonenum,password) values (#{phonenum},#{password})")
    void addHouseownerAccount(String phonenum,String password);

    @Select("select owner_id from house_owner where phonenum = #{phonenum}")
    Integer getHouseownerId(String phonenum);

    @Update("update house_owner set phonenum = #{phonenum},password = #{password},nickname = #{nickname}," +
            "owner_gender = #{owner_gender},owner_age = #{owner_age} where owner_id = #{owner_id}")
    void updateHouseowner(HouseOwner houseOwner);

    @Update("update house_owner set owner_identitynum = #{owner_identitynum},owner_name = #{owner_name} where owner_id = #{owner_id}")
    void updateHouseownerIdentitynum(String owner_identitynum,String owner_name,Integer owner_id);
}
