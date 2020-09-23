package com.element.Service.Imp;

import com.element.Mapper.BusinessMapper;
import com.element.Entity.po.Business;
import com.element.Service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImp implements BusinessService {
    @Autowired(required = false)
    private BusinessMapper businessMapper;

    @Override
    public List<Business> getAllBusiness() {
        return businessMapper.getAllBusiness();
    }

    @Override
    public List<Business> getBusinessByOrderTypeId(Integer orderTypeId){
        return businessMapper.getBusinessByOrderTypeId(orderTypeId);
    }
}
