package com.swjtu.zjz.model;

import java.util.Date;

public class TableAll {
    private Integer owner_id;
    private String owner_identitynum;
    private String owner_name;
    private char owner_gender;
    private Date owner_age;
    private String owner_phonenum;
    private String owner_password;
    private String owner_nickname;
    private Integer tenant_id;
    private String tenant_identitynum;
    private String tenant_name;
    private char tenant_gender;
    private Date tenant_age;
    private String tenant_phonenum;
    private String tenant_password;
    private String tenant_nickname;
    private Integer house_id;
    private String house_address;
    private Integer house_monthlyrent;
    private String house_detail;
    private Integer house_area;
    private String house_use;
    private String house_type;
    private Integer house_floor;
    private String house_decoration; //装修情况
    private char rental_situation; // 租赁情况
    private Integer rent_time;
    private char apply_situation;
    private java.util.Date apply_starttime;
    private String apply_remark;
    private java.util.Date comment_time;
    private char comment_authority;
    private char comment_status;
    private Integer comment_score;
    private String comment_detail;
    private Date contract_startdate;
    private Date contract_enddate;
    private String contract_detail;
    private java.util.Date rent_starttime;
    private Integer need_rent;
    private Integer actual_rent;
    private char rent_status;
    private char apply_result;

    @Override
    public String toString() {
        return "TableAll{" +
                "owner_id=" + owner_id +
                ", owner_identitynum='" + owner_identitynum + '\'' +
                ", owner_name='" + owner_name + '\'' +
                ", owner_gender=" + owner_gender +
                ", owner_age=" + owner_age +
                ", owner_phonenum='" + owner_phonenum + '\'' +
                ", owner_password='" + owner_password + '\'' +
                ", owner_nickname='" + owner_nickname + '\'' +
                ", tenant_id=" + tenant_id +
                ", tenant_identitynum='" + tenant_identitynum + '\'' +
                ", tenant_name='" + tenant_name + '\'' +
                ", tenant_gender=" + tenant_gender +
                ", tenant_age=" + tenant_age +
                ", tenant_phonenum='" + tenant_phonenum + '\'' +
                ", tenant_password='" + tenant_password + '\'' +
                ", tenant_nickname='" + tenant_nickname + '\'' +
                ", house_id=" + house_id +
                ", house_address='" + house_address + '\'' +
                ", house_monthlyrent=" + house_monthlyrent +
                ", house_detail='" + house_detail + '\'' +
                ", house_area=" + house_area +
                ", house_use='" + house_use + '\'' +
                ", house_type='" + house_type + '\'' +
                ", house_floor=" + house_floor +
                ", house_decoration='" + house_decoration + '\'' +
                ", rental_situation=" + rental_situation +
                ", rent_time=" + rent_time +
                ", apply_situation=" + apply_situation +
                ", apply_starttime=" + apply_starttime +
                ", apply_remark='" + apply_remark + '\'' +
                ", comment_time=" + comment_time +
                ", comment_authority=" + comment_authority +
                ", comment_status=" + comment_status +
                ", comment_score=" + comment_score +
                ", comment_detail='" + comment_detail + '\'' +
                ", contract_startdate=" + contract_startdate +
                ", contract_enddate=" + contract_enddate +
                ", contract_detail='" + contract_detail + '\'' +
                ", rent_starttime=" + rent_starttime +
                ", need_rent=" + need_rent +
                ", actual_rent=" + actual_rent +
                ", rent_status=" + rent_status +
                ", apply_result=" + apply_result +
                '}';
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

    public String getOwner_phonenum() {
        return owner_phonenum;
    }

    public void setOwner_phonenum(String owner_phonenum) {
        this.owner_phonenum = owner_phonenum;
    }

    public String getOwner_password() {
        return owner_password;
    }

    public void setOwner_password(String owner_password) {
        this.owner_password = owner_password;
    }

    public String getOwner_nickname() {
        return owner_nickname;
    }

    public void setOwner_nickname(String owner_nickname) {
        this.owner_nickname = owner_nickname;
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

    public String getTenant_phonenum() {
        return tenant_phonenum;
    }

    public void setTenant_phonenum(String tenant_phonenum) {
        this.tenant_phonenum = tenant_phonenum;
    }

    public String getTenant_password() {
        return tenant_password;
    }

    public void setTenant_password(String tenant_password) {
        this.tenant_password = tenant_password;
    }

    public String getTenant_nickname() {
        return tenant_nickname;
    }

    public void setTenant_nickname(String tenant_nickname) {
        this.tenant_nickname = tenant_nickname;
    }

    public Integer getHouse_id() {
        return house_id;
    }

    public void setHouse_id(Integer house_id) {
        this.house_id = house_id;
    }

    public String getHouse_address() {
        return house_address;
    }

    public void setHouse_address(String house_address) {
        this.house_address = house_address;
    }

    public Integer getHouse_monthlyrent() {
        return house_monthlyrent;
    }

    public void setHouse_monthlyrent(Integer house_monthlyrent) {
        this.house_monthlyrent = house_monthlyrent;
    }

    public String getHouse_detail() {
        return house_detail;
    }

    public void setHouse_detail(String house_detail) {
        this.house_detail = house_detail;
    }

    public Integer getHouse_area() {
        return house_area;
    }

    public void setHouse_area(Integer house_area) {
        this.house_area = house_area;
    }

    public String getHouse_use() {
        return house_use;
    }

    public void setHouse_use(String house_use) {
        this.house_use = house_use;
    }

    public String getHouse_type() {
        return house_type;
    }

    public void setHouse_type(String house_type) {
        this.house_type = house_type;
    }

    public Integer getHouse_floor() {
        return house_floor;
    }

    public void setHouse_floor(Integer house_floor) {
        this.house_floor = house_floor;
    }

    public String getHouse_decoration() {
        return house_decoration;
    }

    public void setHouse_decoration(String house_decoration) {
        this.house_decoration = house_decoration;
    }

    public char getRental_situation() {
        return rental_situation;
    }

    public void setRental_situation(char rental_situation) {
        this.rental_situation = rental_situation;
    }

    public Integer getRent_time() {
        return rent_time;
    }

    public void setRent_time(Integer rent_time) {
        this.rent_time = rent_time;
    }

    public char getApply_situation() {
        return apply_situation;
    }

    public void setApply_situation(char apply_situation) {
        this.apply_situation = apply_situation;
    }

    public java.util.Date getApply_starttime() {
        return apply_starttime;
    }

    public void setApply_starttime(java.util.Date apply_starttime) {
        this.apply_starttime = apply_starttime;
    }

    public String getApply_remark() {
        return apply_remark;
    }

    public void setApply_remark(String apply_remark) {
        this.apply_remark = apply_remark;
    }

    public java.util.Date getComment_time() {
        return comment_time;
    }

    public void setComment_time(java.util.Date comment_time) {
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

    public Date getContract_startdate() {
        return contract_startdate;
    }

    public void setContract_startdate(Date contract_startdate) {
        this.contract_startdate = contract_startdate;
    }

    public Date getContract_enddate() {
        return contract_enddate;
    }

    public void setContract_enddate(Date contract_enddate) {
        this.contract_enddate = contract_enddate;
    }

    public String getContract_detail() {
        return contract_detail;
    }

    public void setContract_detail(String contract_detail) {
        this.contract_detail = contract_detail;
    }

    public java.util.Date getRent_starttime() {
        return rent_starttime;
    }

    public void setRent_starttime(java.util.Date rent_starttime) {
        this.rent_starttime = rent_starttime;
    }

    public Integer getNeed_rent() {
        return need_rent;
    }

    public void setNeed_rent(Integer need_rent) {
        this.need_rent = need_rent;
    }

    public Integer getActual_rent() {
        return actual_rent;
    }

    public void setActual_rent(Integer actual_rent) {
        this.actual_rent = actual_rent;
    }

    public char getRent_status() {
        return rent_status;
    }

    public void setRent_status(char rent_status) {
        this.rent_status = rent_status;
    }

    public char getApply_result() {
        return apply_result;
    }

    public void setApply_result(char apply_result) {
        this.apply_result = apply_result;
    }
}
