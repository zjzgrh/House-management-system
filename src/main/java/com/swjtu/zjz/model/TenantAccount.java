package com.swjtu.zjz.model;

public class TenantAccount {
    private String phonenum;
    private String password;

    public TenantAccount(){}

    public TenantAccount(String phonenum,String password){
        this.phonenum = phonenum;
        this.password = password;
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

    @Override
    public String toString() {
        return "TenantAccount{" +
                "phonenum='" + phonenum + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
