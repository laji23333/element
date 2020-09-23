package com.element.Service;

import com.element.Entity.po.Business;

import java.util.List;

public interface BusinessService {
    //获取所有商家信息
    List<Business> getAllBusiness();
    //根据商家类型获取商家列表
    List<Business> getBusinessByOrderTypeId(Integer orderTypeId);
}
