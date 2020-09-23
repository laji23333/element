package com.element.Dao;

import com.element.Entity.po.Business;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BusinessMapper {
    public Business getBusiness(Integer businessId);
    public List<Business> getBusinessList();
}
