package com.element.Entity.po;

public class Address {
    private Integer daID;                   //送货地址编号
    private String contactName;         //联系人姓名
    private Integer contactSex;             //联系人性别
    private String contactTel;          //联系人电话
    private String address;             //送货地址
    private String userId;                 //所属用户编号

    public Integer getDaID() {
        return daID;
    }

    public void setDaID(Integer daID) {
        this.daID = daID;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public Integer getContactSex() {
        return contactSex;
    }

    public void setContactSex(Integer contactSex) {
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
