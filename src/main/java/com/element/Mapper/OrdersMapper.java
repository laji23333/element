package com.element.Mapper;

import com.element.Entity.po.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrdersMapper {
    public Orders getOrders(int orderId);
    public int saveOrders(Orders orders);
    public int pay(int orderId);
    public List<Orders> getAllOrders();
}
