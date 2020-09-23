package com.element.Dao;

import com.element.Entity.Food;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodMapper {
    public List<Food> getAllFood(Integer businessId);
}
