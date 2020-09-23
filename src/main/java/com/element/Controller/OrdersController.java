package com.element.Controller;

import com.alibaba.fastjson.JSONObject;
import com.element.Entity.po.*;
import com.element.Entity.vo.FoodVO;
import com.element.Entity.vo.OrdersVO;
import com.element.Service.BusinessService;
import com.element.Service.FoodService;
import com.element.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private BusinessService businessService;
    @Autowired
    private FoodService foodService;

    //我的订单
    @RequestMapping(value = "getMyOrders", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getMyOrders(HttpServletRequest request){

        List<OrdersVO> ordersVOS=new ArrayList<>();
        String userId = (String) request.getSession().getAttribute("userId");
        System.out.println(userId);

        List<Orders> allOrders = ordersService.getAllOrders(userId);
        System.out.println(allOrders);

        for (Orders orders:ordersService.getAllOrders(userId)){
            List<FoodVO> foods = new ArrayList<FoodVO>();
            OrdersVO ordersVO = new OrdersVO();

            ordersVO.setOrderId(orders.getOrderId());
            ordersVO.setBusinessName(businessService.getBusinessByBusinessId(orders.getBusinessId()).getBusinessName());
            ordersVO.setOrderState(orders.getOrderState());
            ordersVO.setOrderTotal(orders.getOrderTotal());
            List<OrderDetailet> orderdetail = ordersService.getOrderDetailet(orders.getOrderId());

            for (OrderDetailet detail:orderdetail){
                Food food = foodService.getFoodByFoodId(detail.getFoodId());
                FoodVO foodvo = new FoodVO();
                foodvo.setFoodId(food.getFoodId());
                foodvo.setFoodName(food.getFoodName());
                foodvo.setQuantity(detail.getQuantity());
                foodvo.setFoodPrice(food.getFoodPrice()*detail.getQuantity());
                foods.add(foodvo);
            }
            ordersVO.setFoods(foods);
            ordersVOS.add(ordersVO);
        }
        if (ordersVOS.isEmpty()){
            JSONObject result = new JSONObject();
            result.put("status","failure");
            result.put("detail","还没有订单");
            return  result.toJSONString();
        }
        JSONObject result = new JSONObject();
        result.put("status","success");
        result.put("detail",ordersVOS);
        return  result.toJSONString();
    }

    //根据订单id获取订单信息
    @RequestMapping(value = "getMyOrderByOrderId", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getMyOrderByOrderId(@RequestBody Orders orderBO,HttpServletRequest request){

        List<OrdersVO> ordersVOS=new ArrayList<>();

        String userId = (String) request.getSession().getAttribute("userId");
        System.out.println(userId);

        Orders orders = ordersService.getOrders(orderBO.getOrderId());
        List<FoodVO> foods = new ArrayList<FoodVO>();
        OrdersVO ordersVO = new OrdersVO();

        ordersVO.setOrderId(orders.getOrderId());
        ordersVO.setBusinessName(businessService.getBusinessByBusinessId(orders.getBusinessId()).getBusinessName());
        ordersVO.setOrderState(orders.getOrderState());
        ordersVO.setOrderTotal(orders.getOrderTotal());
        List<OrderDetailet> orderdetail = ordersService.getOrderDetailet(orders.getOrderId());

        for (OrderDetailet detail:orderdetail){
            Food food = foodService.getFoodByFoodId(detail.getFoodId());
            FoodVO foodvo = new FoodVO();
            foodvo.setFoodId(food.getFoodId());
            foodvo.setFoodName(food.getFoodName());
            foodvo.setQuantity(detail.getQuantity());
            foodvo.setFoodPrice(food.getFoodPrice()*detail.getQuantity());
            foods.add(foodvo);
        }
            ordersVO.setFoods(foods);
            ordersVOS.add(ordersVO);

        if (ordersVOS.isEmpty()){
            JSONObject result = new JSONObject();
            result.put("status","failure");
            result.put("detail","还没有订单");
            return  result.toJSONString();
        }
        JSONObject result = new JSONObject();
        result.put("status","success");
        result.put("detail",ordersVOS);
        return  result.toJSONString();
    }

    //添加订单
    @RequestMapping(value = "addOrder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String addOrder(@RequestBody OrdersVO orderVO,HttpServletRequest request){

        String userId = (String) request.getSession().getAttribute("userId");
        Orders order = new Orders();
        OrderDetailet orderDetail = new OrderDetailet();

        order.setUserId(userId);
        order.setBusinessId(orderVO.getBusinessId());
        order.setDaId(orderVO.getDaId());
        order.setOrderDate(orderVO.getOrderDate());
        order.setOrderTotal(orderVO.getOrderTotal());
        order.setOrderState(0);
        ordersService.saveOrders(order);

        for (FoodVO foodvo: orderVO.getFoods()){
            orderDetail.setFoodId(foodvo.getFoodId());
            orderDetail.setOrderId(order.getOrderId());
            orderDetail.setQuantity(foodvo.getQuantity());
            ordersService.saveOrderDetails(orderDetail);
        }


        int orderId = order.getOrderId();
        JSONObject result = new JSONObject();
        result.put("status", "success");
        result.put("detail","添加订单成功！");
        result.put("orderId",orderId);
        return result.toJSONString();
    }

    //修改订单状态
    @RequestMapping(value = "updateOrderStatus", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String updateOrderStatus(@RequestBody OrdersVO orderVO,HttpServletRequest request){

        Integer orderId = orderVO.getOrderId();
        ordersService.pay(orderId);
        JSONObject result = new JSONObject();
        result.put("status", "success");
        result.put("detail","订单状态改为已支付！");
        result.put("orderId",orderId);
        return result.toJSONString();
    }


}
