package com.element.Mapper;

import com.element.Entity.po.Food;
import com.element.Entity.po.OrderDetailet;
import com.element.Entity.po.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrdersMapper {
    public Orders getOrders(Integer orderId);
    public int saveOrders(Orders orders);
    public int pay(Integer orderId);
    public List<Orders> getAllOrders(String userId);
    public OrderDetailet getOrderDetailet(Integer orderId);
}
