package com.element.Mapper;

import com.element.Entity.po.Business;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BusinessMapper {
    List<Business> getAllBusiness();
    List<Business> getBusinessByOrderTypeId(Integer orderTypeId);
}
