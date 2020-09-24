package com.element.Service.Imp;

import com.element.Mapper.BusinessMapper;
import com.element.Entity.po.Business;
import com.element.Mapper.FoodMapper;
import com.element.Service.BusinessService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BusinessServiceImp implements BusinessService {
    @Autowired
    private BusinessMapper businessMapper;

    @Autowired(required = false)
    private FoodMapper foodMapper;

    @Override
    public List<Business> getAllBusiness() {
        return businessMapper.getAllBusiness();
    }

    @Override
    public List<Business> getBusinessByOrderTypeId(Integer orderTypeId){
        return businessMapper.getBusinessByOrderTypeId(orderTypeId);
    }

    @Override
    public Map<String, Object> getBusiness(Integer businessId) {
        Map<String,Object> businessMap = new HashMap<String,Object>();
        businessMap.put("1",businessMapper.getBusiness(businessId));
        businessMap.put("2",foodMapper.getAllFood(businessId));
        return businessMap;
    }

    @Override
    public Business getBusinessByBusinessId(Integer businessId){
        return businessMapper.getBusiness(businessId);
    }
}
