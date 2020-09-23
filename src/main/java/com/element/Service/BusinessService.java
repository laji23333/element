package com.element.Service;

import com.element.Entity.Business;
import com.element.Entity.Food;

import java.util.List;
import java.util.Map;

public interface BusinessService {
    public Map<Integer,Object> getBusiness(Integer businessId);                   //获取商家信息和食物
}
