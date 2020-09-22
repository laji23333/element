package com.element.Service.Imp;

import com.element.Dao.BusinessMapper;
import com.element.Entity.po.Business;
import com.element.Service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImp implements BusinessService {
    @Autowired(required=false)
    private BusinessMapper businessMapper;

    @Override
    public Business getBusiness(Integer businessId) {
        return businessMapper.getBusiness(businessId);
    }
}
