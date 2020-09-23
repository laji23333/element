package com.element.Entity.vo;

import com.element.Entity.po.Food;

import java.util.List;

public class OrdersVO {
    private Integer orderId;    //订单id
    private Integer businessId;   //商家id
    private Integer daId;   //商家id
    private String orderDate;   //订单提交日期
    private String businessName;   //商家名字
    private String orderTotal;      //订单总价
    private Integer orderState;     //订单状态
    private List<FoodVO> Foods;     //订单下的商品名

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(String orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public List<FoodVO> getFoods() {
        return Foods;
    }

    public void setFoods(List<FoodVO> foods) {
        Foods = foods;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Integer getDaId() {
        return daId;
    }

    public void setDaId(Integer daId) {
        this.daId = daId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
