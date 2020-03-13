package com.swjtu.zjz.bean;

import org.springframework.context.annotation.Bean;


public class OwnerAccount {
    private String phonenum;
    private String password;

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
        return "OwnerAccount{" +
                "phonenum='" + phonenum + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}