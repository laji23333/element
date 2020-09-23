package com.element.Service.Imp;

import com.element.Dao.BusinessMapper;
import com.element.Dao.FoodMapper;
import com.element.Entity.Business;
import com.element.Entity.Food;
import com.element.Service.BusinessService;
import com.fasterxml.jackson.core.util.InternCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BusinessServiceImp implements BusinessService {
    @Autowired
    private BusinessMapper businessMapper;

    @Autowired
    private FoodMapper foodMapper;

    @Override
    public Map<Integer,Object> getBusiness(Integer businessId) {
        Map<Integer,Object> businessMap = new HashMap<Integer,Object>();
        businessMap.put(1,businessMapper.getBusiness(businessId));
        businessMap.put(2,foodMapper.getAllFood(businessId));
        return businessMap;
    }


}
