package com.element.Mapper;

import com.element.Entity.po.Food;
import com.element.Entity.po.OrderDetailet;
import com.element.Entity.po.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrdersMapper {
    Orders getOrders(Integer orderId);
    int saveOrders(Orders orders);
    int saveOrderDetails(OrderDetailet orderDetails);
    int pay(Integer orderId);
    List<Orders> getAllOrders(String userId);
    List<OrderDetailet> getOrderDetailet(Integer orderId);
}
