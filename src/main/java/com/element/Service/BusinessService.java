package com.element.Service;

import com.element.Entity.po.Business;

import java.util.List;

public interface BusinessService {
    public Business getBusiness(Integer businessId);
    public List<Business> getBusinessList();
}
