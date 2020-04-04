package com.swjtu.zjz.model;

public class OwnerAccount {
    private String phonenum;
    private String password;
    private String owner_identitynum;

    public OwnerAccount(){}

    public OwnerAccount(String phonenum,String password){
        this.phonenum = phonenum;
        this.password = password;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOwner_identitynum() {
        return owner_identitynum;
    }

    public void setOwner_identitynum(String owner_identitynum) {
        this.owner_identitynum = owner_identitynum;
    }

    @Override
    public String toString() {
        return "OwnerAccount{" +
                "phonenum='" + phonenum + '\'' +
                ", password='" + password + '\'' +
                ", owner_identitynum='" + owner_identitynum + '\'' +
                '}';
    }
}
