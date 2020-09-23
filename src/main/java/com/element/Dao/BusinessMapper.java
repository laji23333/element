package com.element.Dao;

import com.element.Entity.Business;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BusinessMapper {
    List<Business> getAllBusiness();
    List<Business> getBusinessByOrderTypeId(Integer orderTypeId);
}
