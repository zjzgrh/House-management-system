package com.swjtu.zjz.dao;

import com.swjtu.zjz.model.OwnerAccount;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ownerAccountMapper {

    @Insert("insert into owner_account(phonenum,password) values (#{phonenum},#{password})")
    void insert (OwnerAccount ownerAccount);

    @Select("select * from owner_account where phonenum = #{phonenum}")
    OwnerAccount select (String phonenum);

    @Update("update owner_account set phonenum = #{phonenum},password = #{password} where phonenum = #{phonenum}")
    void updateOwnerAccount(OwnerAccount ownerAccount);

    @Update("update owner_account set owner_identitynum = #{identitynum} where phonenum = #{phonenum}")
    void updateOwnerAccountIdentitynum(String identitynum,String phonenum);
}
