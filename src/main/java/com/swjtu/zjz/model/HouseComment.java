package com.swjtu.zjz.model;

import org.omg.CORBA.INTERNAL;

import java.util.Date;

public class HouseComment {
    private String tenant_identitynum;
    private Integer house_id;
    private Date comment_time;
    private char comment_authority;
    private Integer comment_score;
    private String comment_detail;

    public HouseComment(){}

    public HouseComment(String tenant_identitynum, Integer house_id, Date comment_time, char comment_authority, Integer comment_score, String comment_detail) {
        this.tenant_identitynum = tenant_identitynum;
        this.house_id = house_id;
        this.comment_time = comment_time;
        this.comment_authority = comment_authority;
        this.comment_score = comment_score;
        this.comment_detail = comment_detail;
    }

    public String getTenant_identitynum() {
        return tenant_identitynum;
    }

    public void setTenant_identitynum(String tenant_identitynum) {
        this.tenant_identitynum = tenant_identitynum;
    }

    public Integer getHouse_id() {
        return house_id;
    }

    public void setHouse_id(Integer house_id) {
        this.house_id = house_id;
    }

    public Date getComment_time() {
        return comment_time;
    }

    public void setComment_time(Date comment_time) {
        this.comment_time = comment_time;
    }

    public char getComment_authority() {
        return comment_authority;
    }

    public void setComment_authority(char comment_authority) {
        this.comment_authority = comment_authority;
    }

    public Integer getComment_score() {
        return comment_score;
    }

    public void setComment_score(Integer comment_score) {
        this.comment_score = comment_score;
    }

    public String getComment_detail() {
        return comment_detail;
    }

    public void setComment_detail(String comment_detail) {
        this.comment_detail = comment_detail;
    }

    @Override
    public String toString() {
        return "HouseComment{" +
                "tenant_identitynum='" + tenant_identitynum + '\'' +
                ", house_id=" + house_id +
                ", comment_time=" + comment_time +
                ", comment_authority=" + comment_authority +
                ", comment_score=" + comment_score +
                ", comment_detail='" + comment_detail + '\'' +
                '}';
    }
}
