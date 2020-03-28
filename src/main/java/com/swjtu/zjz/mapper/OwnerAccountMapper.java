package com.swjtu.zjz.mapper;

import com.swjtu.zjz.bean.OwnerAccount;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OwnerAccountMapper {

    @Insert("insert into owner_account(phonenum,password,role) values (#{phonenum},#{password},#{role})")
    void insert (OwnerAccount ownerAccount);

    @Select("select * from owner_account where phonenum = #{phonenum}")
    OwnerAccount select (String phonenum);
}
