package com.element.Service.Imp;

import com.element.Dao.OrdersMapper;
import com.element.Entity.po.Orders;
import com.element.Service.OrdersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    private OrdersMapper ordersMapper;
    @Override
    public Orders getOrders(Integer orderId) {
        return null;
    }

    @Override
    public int saveOrders(Orders orders) {
        return 0;
    }

    @Override
    public int pay(Integer orderId) {
        return 0;
    }

    @Override
    public List<Orders> getOrdersList() {
        return null;
    }
}
