package com.element.Mapper;

import com.element.Entity.po.Food;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodMapper {
    List<Food> getAllFood(Integer businessId);
}
