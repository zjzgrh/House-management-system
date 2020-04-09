package com.swjtu.zjz.model;

import java.sql.Date;

public class HouseOwner {
    private Integer owner_id;
    private String owner_identitynum;
    private String owner_name;
    private char owner_gender;
    private Date owner_age;
    private String phonenum;
    private String password;
    private String nickname;

    public HouseOwner(){}

    public HouseOwner(String owner_identitynum,String owner_name){
        this.owner_identitynum = owner_identitynum;
        this.owner_name = owner_name;
    }
    public HouseOwner(String phonenum, String password,String nickname, char owner_gender, Date owner_age) {
        this.owner_age = owner_age;
        this.phonenum = phonenum;
        this.password = password;
        this.nickname = nickname;
        this.owner_gender = owner_gender;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }

    public String getOwner_identitynum() {
        return owner_identitynum;
    }

    public void setOwner_identitynum(String owner_identitynum) {
        this.owner_identitynum = owner_identitynum;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public char getOwner_gender() {
        return owner_gender;
    }

    public void setOwner_gender(char owner_gender) {
        this.owner_gender = owner_gender;
    }

    public Date getOwner_age() {
        return owner_age;
    }

    public void setOwner_age(Date owner_age) {
        this.owner_age = owner_age;
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
        return "HouseOwner{" +
                "owner_id=" + owner_id +
                ", owner_identitynum='" + owner_identitynum + '\'' +
                ", owner_name='" + owner_name + '\'' +
                ", owner_gender=" + owner_gender +
                ", owner_age=" + owner_age +
                ", phonenum='" + phonenum + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
