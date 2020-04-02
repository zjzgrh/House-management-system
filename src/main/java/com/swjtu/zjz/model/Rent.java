package com.swjtu.zjz.model;

import java.sql.Date;

public class Rent {
    private String owner_identitynum;
    private String tenant_identitynum;
    private Integer house_id;
    private Date rent_startdate;
    private Integer rent_time;
    private Integer need_rent;
    private Integer actual_rent;

    public Rent(){}

    public Rent(String owner_identitynum, String tenant_identitynum, Integer house_id, Date rent_startdate, Integer rent_time, Integer need_rent, Integer actual_rent) {
        this.owner_identitynum = owner_identitynum;
        this.tenant_identitynum = tenant_identitynum;
        this.house_id = house_id;
        this.rent_startdate = rent_startdate;
        this.rent_time = rent_time;
        this.need_rent = need_rent;
        this.actual_rent = actual_rent;
    }

    public String getOwner_identitynum() {
        return owner_identitynum;
    }

    public void setOwner_identitynum(String owner_identitynum) {
        this.owner_identitynum = owner_identitynum;
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

    public Date getRent_startdate() {
        return rent_startdate;
    }

    public void setRent_startdate(Date rent_startdate) {
        this.rent_startdate = rent_startdate;
    }

    public Integer getRent_time() {
        return rent_time;
    }

    public void setRent_time(Integer rent_time) {
        this.rent_time = rent_time;
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

    @Override
    public String toString() {
        return "Rent{" +
                "owner_identitynum='" + owner_identitynum + '\'' +
                ", tenant_identitynum='" + tenant_identitynum + '\'' +
                ", house_id=" + house_id +
                ", rent_startdate=" + rent_startdate +
                ", rent_time=" + rent_time +
                ", need_rent=" + need_rent +
                ", actual_rent=" + actual_rent +
                '}';
    }
}
