package com.element.Service;

import com.element.Entity.po.Business;

import java.util.List;
import java.util.Map;

public interface BusinessService {
    public List<Business> getAllBusiness();
    public List<Business> getBusinessByOrderTypeId(Integer orderTypeId);
    public Map<Integer,Object> getBusiness(Integer businessId);
}
