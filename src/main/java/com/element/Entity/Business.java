package com.element.Entity;

public class Business {
    private int businessId;
    private String businessName;
    private String businessAddress;
    private String businessExplain;
    private String businessImg;
    private int orderTypeId;

    public int getBusinessId() {
        return businessId;
    }
    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }
    public String getBusinessName() {
        return businessName;
    }
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
    public String getBusinessAddress() {
        return businessAddress;
    }
    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }
    public String getBusinessExplain() {
        return businessExplain;
    }
    public void setBusinessExplain(String businessExplain) {
        this.businessExplain = businessExplain;
    }
    public String getBusinessImg() {
        return businessImg;
    }
    public void setBusinessImg(String businessImg) {
        this.businessImg = businessImg;
    }
    public int getOrderTypeId() {
        return orderTypeId;
    }
    public void setOrderTypeId(int orderTypeId) {
        this.orderTypeId = orderTypeId;
    }
}
