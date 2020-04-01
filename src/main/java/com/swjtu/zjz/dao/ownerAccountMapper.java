package com.swjtu.zjz.dao;

import com.swjtu.zjz.model.OwnerAccount;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ownerAccountMapper {

    @Insert("insert into owner_account(phonenum,password) values (#{phonenum},#{password})")
    void insert (OwnerAccount ownerAccount);

    @Select("select * from owner_account where phonenum = #{phonenum}")
    OwnerAccount select (String phonenum);
}
