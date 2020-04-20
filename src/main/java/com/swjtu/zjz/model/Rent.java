package com.swjtu.zjz.model;


import java.util.Date;

public class Rent {
    private Integer owner_id;
    private Integer tenant_id;
    private Integer house_id;
    private Date rent_starttime;
    private Integer rent_time;
    private Integer need_rent;
    private Integer actual_rent;
    private char rent_status;

    public Rent(){}

    public Rent(Integer owner_id, Integer tenant_id, Integer house_id, Date rent_starttime) {
        this.owner_id = owner_id;
        this.tenant_id = tenant_id;
        this.house_id = house_id;
        this.rent_starttime = rent_starttime;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
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

    public Date getRent_starttime() {
        return rent_starttime;
    }

    public void setRent_starttime(Date rent_starttime) {
        this.rent_starttime = rent_starttime;
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

    public char getRent_status() {
        return rent_status;
    }

    public void setRent_status(char rent_status) {
        this.rent_status = rent_status;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "owner_id=" + owner_id +
                ", tenant_id=" + tenant_id +
                ", house_id=" + house_id +
                ", rent_starttime=" + rent_starttime +
                ", rent_time=" + rent_time +
                ", need_rent=" + need_rent +
                ", actual_rent=" + actual_rent +
                ", rent_status=" + rent_status +
                '}';
    }
}
