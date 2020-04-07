package com.swjtu.zjz.dao;


import com.swjtu.zjz.model.OwnerAccount;
import com.swjtu.zjz.model.TenantAccount;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface tenantAccountMapper {
    @Insert("insert into tenant_account(phonenum,password) values (#{phonenum},#{password})")
    void insert (TenantAccount tenantAccount);

    @Select("select * from tenant_account where phonenum = #{phonenum}")
    TenantAccount select (String phonenum);

    @Update("update tenant_account set phonenum = #{newphonenum},password = #{newpassword} where phonenum = #{oldphonenum}")
    void updateTenantAccount(String newphonenum,String newpassword,String oldphonenum);

    @Update("update tenant_account set tenant_identitynum = #{identitynum} where phonenum = #{phonenum}")
    void updateTenantAccountIdentitynum(String identitynum,String phonenum);
}
