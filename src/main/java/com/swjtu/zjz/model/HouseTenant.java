package com.swjtu.zjz.model;

import java.sql.Date;

public class HouseTenant {
    private Integer tenant_id;
    private String tenant_identitynum;
    private String tenant_name;
    private char tenant_gender;
    private Date tenant_age;
    private String phonenum;
    private String password;
    private String nickname;


    public HouseTenant(){}

    public HouseTenant(String phonenum,String password,String nickname,char tenant_gender,Date tenant_age){
        this.phonenum = phonenum;
        this.password = password;
        this.nickname = nickname;
        this.tenant_gender = tenant_gender;
        this.tenant_age = tenant_age;
    }

    public HouseTenant(String tenant_identitynum, String tenant_name, char tenant_gender, Date tenant_age, String phonenum, String password) {
        this.tenant_identitynum = tenant_identitynum;
        this.tenant_name = tenant_name;
        this.tenant_gender = tenant_gender;
        this.tenant_age = tenant_age;
        this.phonenum = phonenum;
        this.password = password;
    }

    public Integer getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(Integer tenant_id) {
        this.tenant_id = tenant_id;
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

    public char getTenant_gender() {
        return tenant_gender;
    }

    public void setTenant_gender(char tenant_gender) {
        this.tenant_gender = tenant_gender;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HouseTenant{" +
                "tenant_id=" + tenant_id +
                ", tenant_identitynum='" + tenant_identitynum + '\'' +
                ", tenant_name='" + tenant_name + '\'' +
                ", tenant_gender=" + tenant_gender +
                ", tenant_age=" + tenant_age +
                ", phonenum='" + phonenum + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
