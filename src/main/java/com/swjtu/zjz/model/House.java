package com.swjtu.zjz.model;

public class House {
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
    private Integer owner_id;
    private char apply_situation;

    public House(){}

    public House(String house_address, Integer house_monthlyrent, String house_detail, Integer house_area, String house_use,
                 String house_type, Integer house_floor, String house_decoration,Integer rent_time) {
        this.house_address = house_address;
        this.house_monthlyrent = house_monthlyrent;
        this.house_detail = house_detail;
        this.house_area = house_area;
        this.house_use = house_use;
        this.house_type = house_type;
        this.house_floor = house_floor;
        this.house_decoration = house_decoration;
        this.rent_time = rent_time;
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

    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }

    public char getApply_situation() {
        return apply_situation;
    }

    public void setApply_situation(char apply_situation) {
        this.apply_situation = apply_situation;
    }

    @Override
    public String toString() {
        return "House{" +
                "house_id=" + house_id +
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
                ", owner_id=" + owner_id +
                ", apply_situation=" + apply_situation +
                '}';
    }
}
