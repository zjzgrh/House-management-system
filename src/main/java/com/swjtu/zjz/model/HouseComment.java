package com.swjtu.zjz.model;

import org.omg.CORBA.INTERNAL;

import java.util.Date;

public class HouseComment {
    private Integer tenant_id;
    private Integer house_id;
    private Date comment_time;
    private char comment_authority;
    private char comment_status;
    private Integer comment_score;
    private String comment_detail;

    public HouseComment(){}

    public HouseComment(int tenant_id, Integer house_id, Date comment_time, char comment_authority, char comment_status, Integer comment_score, String comment_detail) {
        this.tenant_id = tenant_id;
        this.house_id = house_id;
        this.comment_time = comment_time;
        this.comment_authority = comment_authority;
        this.comment_status = comment_status;
        this.comment_score = comment_score;
        this.comment_detail = comment_detail;
    }

    public Integer getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(Integer tenant_id) {
        this.tenant_id = tenant_id;
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

    public char getComment_status() {
        return comment_status;
    }

    public void setComment_status(char comment_status) {
        this.comment_status = comment_status;
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
                "tenant_id=" + tenant_id +
                ", house_id=" + house_id +
                ", comment_time=" + comment_time +
                ", comment_authority=" + comment_authority +
                ", comment_status=" + comment_status +
                ", comment_score=" + comment_score +
                ", comment_detail='" + comment_detail + '\'' +
                '}';
    }
}
