package com.element.Entity;

public class OrderDetailet {
    private int odId;
    private int orderId;
    private int foodId;
    private int quantity;

    public int getOdId() {
        return odId;
    }
    public void setOdId(int odId) {
        this.odId = odId;
    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public int getFoodId() {
        return foodId;
    }
    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
