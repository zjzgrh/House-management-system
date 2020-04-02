package com.swjtu.zjz.model;

import java.sql.Date;

public class HouseTenant {
    private String tenant_identitynum;
    private String tenant_name;
    private char tenant_sex;
    private Date tenant_age;
    private String phonenum;

    public HouseTenant(){}

    public HouseTenant(String tenant_identitynum, String tenant_name, char tenant_sex, Date tenant_age, String phonenum) {
        this.tenant_identitynum = tenant_identitynum;
        this.tenant_name = tenant_name;
        this.tenant_sex = tenant_sex;
        this.tenant_age = tenant_age;
        this.phonenum = phonenum;
    }

    public String getTenant_identitynum() {
        return tenant_identitynum;
    }

    public void setTenant_identitynum(String tenant_identitynum) {
        this.tenant_identitynum = tenant_identitynum;
    }

    public String getTenant_name() {
        return tenant_name;
    }

    public void setTenant_name(String tenant_name) {
        this.tenant_name = tenant_name;
    }

    public char getTenant_sex() {
        return tenant_sex;
    }

    public void setTenant_sex(char tenant_sex) {
        this.tenant_sex = tenant_sex;
    }

    public Date getTenant_age() {
        return tenant_age;
    }

    public void setTenant_age(Date tenant_age) {
        this.tenant_age = tenant_age;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    @Override
    public String toString() {
        return "HouseTenant{" +
                "tenant_identitynum='" + tenant_identitynum + '\'' +
                ", tenant_name='" + tenant_name + '\'' +
                ", tenant_sex=" + tenant_sex +
                ", tenant_age=" + tenant_age +
                ", phonenum='" + phonenum + '\'' +
                '}';
    }
}
