package com.element.Service;

import com.element.Entity.po.Food;
import com.element.Entity.po.OrderDetailet;
import com.element.Entity.po.Orders;

import java.util.List;

public interface OrdersService {
    public Orders getOrders(Integer orderId);
    public int saveOrders(Orders orders);
    public int pay(Integer orderId);
    public List<Orders> getAllOrders(String userId);
    public OrderDetailet getOrderDetailet(Integer orderId);
}
