package com.element.Dao;

import com.element.Entity.po.Orders;
import org.apache.ibatis.annotations.Mapper;
import sun.nio.cs.ThreadLocalCoders;

import java.util.List;

@Mapper
public interface OrdersMapper {
    public Orders getOrders(Integer orderId);
    public int saveOrders(Orders orders);
    public int pay(Integer orderId);
    public List<Orders> getOrdersList();
}
