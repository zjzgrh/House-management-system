package com.swjtu.zjz.dao;


import com.swjtu.zjz.model.TenantAccount;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface tenantAccountMapper {
    @Insert("insert into tenant_account(phonenum,password) values (#{phonenum},#{password})")
    void insert (TenantAccount tenantAccount);

    @Select("select * from tenant_account where phonenum = #{phonenum}")
    TenantAccount select (String phonenum);
}
