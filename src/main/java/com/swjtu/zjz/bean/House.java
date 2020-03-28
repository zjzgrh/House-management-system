package com.swjtu.zjz.bean;

public class House {
    private Integer house_id;
    private String house_address;
    private Integer house_monthlyrent;
    private String house_detail;
    private Integer house_area;

    public House(){}
    public House(String house_address,Integer house_monthlyrent,String house_detail,Integer house_area){
        this.house_address = house_address;
        this.house_monthlyrent = house_monthlyrent;
        this.house_detail = house_detail;
        this.house_area = house_area;
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

    @Override
    public String toString() {
        return "House{" +
                "house_id=" + house_id +
                ", house_address='" + house_address + '\'' +
                ", house_monthlyrent=" + house_monthlyrent +
                ", house_detail='" + house_detail + '\'' +
                ", house_area=" + house_area +
                '}';
    }
}
