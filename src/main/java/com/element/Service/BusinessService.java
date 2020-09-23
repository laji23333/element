package com.element.Service;

import com.element.Entity.po.Business;

import java.util.List;

public interface BusinessService {
    public List<Business> getAllBusiness();
    public List<Business> getBusinessByOrderTypeId(Integer orderTypeId);
}
