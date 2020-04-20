package com.swjtu.zjz.model;

import java.sql.Date;

public class HouseContract {
    private Date contract_startdate;
    private Date contract_enddate;
    private String contract_detail;
    private Integer owner_id;
    private Integer tenant_id;
    private Integer house_id;

    public HouseContract(){}

    public HouseContract(Date contract_startdate, Date contract_enddate, String contract_detail, Integer owener_id, Integer tenant_id, Integer house_id) {
        this.contract_startdate = contract_startdate;
        this.contract_enddate = contract_enddate;
        this.contract_detail = contract_detail;
        this.owner_id = owener_id;
        this.tenant_id = tenant_id;
        this.house_id = house_id;
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

    @Override
    public String toString() {
        return "HouseContract{" +
                "contract_startdate=" + contract_startdate +
                ", contract_enddate=" + contract_enddate +
                ", contract_detail='" + contract_detail + '\'' +
                ", owner_id=" + owner_id +
                ", tenant_id=" + tenant_id +
                ", house_id=" + house_id +
                '}';
    }
}
