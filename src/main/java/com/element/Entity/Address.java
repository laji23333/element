package com.element.Entity.po;

public class Address {
    private int daID;                   //送货地址编号
    private String contactName;         //联系人姓名
    private int contactSex;             //联系人性别
    private String contactTel;          //联系人电话
    private String address;             //送货地址
    private String userId;                 //所属用户编号

    public int getDaID() {
        return daID;
    }

    public void setDaID(int daID) {
        this.daID = daID;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public int getContactSex() {
        return contactSex;
    }

    public void setContactSex(int contactSex) {
        this.contactSex = contactSex;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
