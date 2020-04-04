package com.swjtu.zjz.model;

import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import java.sql.Date;

public class HouseOwner {
    private String owner_identitynum;
    private String owner_name;
    private char owner_sex;
    private Date owner_age;

    public HouseOwner(){}

    public HouseOwner(String owner_identitynum, String owner_name, char owner_sex, Date owner_age) {
        this.owner_identitynum = owner_identitynum;
        this.owner_name = owner_name;
        this.owner_sex = owner_sex;
        this.owner_age = owner_age;
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

    public char getOwner_sex() {
        return owner_sex;
    }

    public void setOwner_sex(char owner_sex) {
        this.owner_sex = owner_sex;
    }

    public Date getOwner_age() {
        return owner_age;
    }

    public void setOwner_age(Date owner_age) {
        this.owner_age = owner_age;
    }

    @Override
    public String toString() {
        return "HouseOwner{" +
                "owner_identitynum='" + owner_identitynum + '\'' +
                ", owner_name='" + owner_name + '\'' +
                ", owner_sex=" + owner_sex +
                ", owner_age=" + owner_age +
                '}';
    }
}
