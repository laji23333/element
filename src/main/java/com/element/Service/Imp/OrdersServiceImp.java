package com.element.Service.Imp;

import com.element.Mapper.OrdersMapper;
import com.element.Entity.po.Orders;
import com.element.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImp implements OrdersService {

    @Autowired(required=false)
    private OrdersMapper ordersMapper;
    @Override
    public Orders getOrders(Integer orderId) {
        return ordersMapper.getOrders(orderId);
    }

    @Override
    public int saveOrders(Orders orders) {
        return ordersMapper.saveOrders(orders);
    }

    @Override
    public int pay(Integer orderId) {
        return ordersMapper.pay(orderId);
    }

    @Override
    public List<Orders> getAllOrders() {
        return ordersMapper.getAllOrders();
    }
}
