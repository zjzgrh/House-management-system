package com.swjtu.zjz.model;

import org.springframework.data.relational.core.sql.In;

import java.util.Date;

public class HouseApply {
    private Integer tenant_id;
    private Integer house_id;
    private Date apply_starttime;
    private String apply_remark;

    HouseApply(){}

    public HouseApply(Integer tenant_id, Integer house_id, Date apply_starttime, String apply_remark) {
        this.tenant_id = tenant_id;
        this.house_id = house_id;
        this.apply_starttime = apply_starttime;
        this.apply_remark = apply_remark;
    }

    public Integer getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(int tenant_id) {
        this.tenant_id = tenant_id;
    }

    public Integer getHouse_id() {
        return house_id;
    }

    public void setHouse_id(int house_id) {
        this.house_id = house_id;
    }

    public Date getApply_starttime() {
        return apply_starttime;
    }

    public void setApply_starttime(Date apply_starttime) {
        this.apply_starttime = apply_starttime;
    }

    public String getApply_remark() {
        return apply_remark;
    }

    public void setApply_remark(String apply_remark) {
        this.apply_remark = apply_remark;
    }

    @Override
    public String toString() {
        return "HouseApply{" +
                "tenant_id=" + tenant_id +
                ", house_id=" + house_id +
                ", apply_starttime=" + apply_starttime +
                ", apply_remark='" + apply_remark + '\'' +
                '}';
    }
}
