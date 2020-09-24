package com.element.Service;

import com.element.Entity.po.Business;

import java.util.List;
import java.util.Map;

public interface BusinessService {
    List<Business> getAllBusiness();
    List<Business> getBusinessByOrderTypeId(Integer orderTypeId);
    Map<String,Object> getBusiness(Integer businessId);
    Business getBusinessByBusinessId(Integer businessId);
}
