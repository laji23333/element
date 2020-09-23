package com.element.Service;

import com.element.Entity.po.Food;
import com.element.Entity.po.OrderDetailet;
import com.element.Entity.po.Orders;

import java.util.List;

public interface OrdersService {
    Orders getOrders(Integer orderId);
    int saveOrders(Orders orders);
    int saveOrderDetails(OrderDetailet orderDetails);
    int pay(Integer orderId);
    List<Orders> getAllOrders(String userId);
    List<OrderDetailet> getOrderDetailet(Integer orderId);
}
