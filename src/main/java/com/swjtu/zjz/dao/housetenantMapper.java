package com.swjtu.zjz.dao;

import com.swjtu.zjz.model.HouseOwner;
import com.swjtu.zjz.model.HouseTenant;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface housetenantMapper {
    @Insert("insert into house_tenant (tenant_identitynum,tenant_name,tenant_sex,tenant_age) " +
            "values (#{tenant_identitynum},#{tenant_name},#{tenant_sex},#{tenant_age})")
    void addhousetenant(HouseTenant houseTenant);

    @Select("select * from house_tenant where tenant_identitynum = #{tenant_identitynum}")
    HouseTenant findHouseTenant(String tenant_identitynum);

    //查询手机号是否被注册
    @Select("select * from house_tenant where phonenum = #{phonenum}")
    HouseTenant findPhonenum(String phonenum);

    //注册账号(手机号和密码)
    @Insert("insert into house_tenant (phonenum,password) values (#{phonenum},#{password})")
    void addHousetenantAccount(String phonenum,String password);

    @Select("select tenant_id from house_tenant where phonenum = #{phonenum}")
    Integer getHousetenantId(String phonenum);

    @Select("select * from house_tenant where tenant_id = #{tenant_id}")
    HouseTenant findTenantid(Integer tenant_id);

    @Update("update house_tenant set phonenum = #{newphonenum},password = #{newpassword},nickname = #{nickname}," +
            "tenant_gender = #{tenant_gender},tenant_age = #{tenant_age} where tenant_id = #{tenant_id}")
    void updateHousetenant(HouseTenant houseTenant);

    @Update("update house_tenant set owner_identitynum = #{identitynum},tenant_name = #{name} where tenant_id = #{tenant_id}")
    void updateHousetenantIdentitynum(String identitynum, String name, Integer tenant_id);
}
