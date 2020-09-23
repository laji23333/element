package com.element.Dao;

import com.element.Entity.Business;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BusinessMapper {
    Business getBusiness(Integer businessId);
}
