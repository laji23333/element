package com.element.Entity;

public class Orders {
    private int orderId;
    private String userId;
    private int businessId;
    private String orderDate;
    private String orderTotal;
    private int daId;
    private int orderState;

    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public int getBusinessId() {
        return businessId;
    }
    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    public String getOrderTotal() {
        return orderTotal;
    }
    public void setOrderTotal(String orderTotal) {
        this.orderTotal = orderTotal;
    }
    public int getDaId() {
        return daId;
    }
    public void setDaId(int daId) {
        this.daId = daId;
    }
    public int getOrderState() {
        return orderState;
    }
    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }
}
