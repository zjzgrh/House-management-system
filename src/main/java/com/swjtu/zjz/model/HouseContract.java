package com.swjtu.zjz.model;

import java.sql.Date;

public class HouseContract {
    private Date contract_startdate;
    private Date contract_enddate;
    private String contract_detail;
    private String owner_identitynum;
    private String tenant_identitynum;
    private Integer house_id;

    public HouseContract(){}

    public HouseContract(Date contract_startdate, Date contract_enddate, String contract_detail, String owner_identitynum, String tenant_identitynum, Integer house_id) {
        this.contract_startdate = contract_startdate;
        this.contract_enddate = contract_enddate;
        this.contract_detail = contract_detail;
        this.owner_identitynum = owner_identitynum;
        this.tenant_identitynum = tenant_identitynum;
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

    @Override
    public String toString() {
        return "HouseContract{" +
                "contract_startdate=" + contract_startdate +
                ", contract_enddate=" + contract_enddate +
                ", contract_detail='" + contract_detail + '\'' +
                ", owner_identitynum='" + owner_identitynum + '\'' +
                ", tenant_identitynum='" + tenant_identitynum + '\'' +
                ", house_id=" + house_id +
                '}';
    }
}
