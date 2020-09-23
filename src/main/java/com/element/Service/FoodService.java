package com.element.Service;

import com.element.Entity.po.Food;

import java.util.List;

public interface FoodService {
    public List<Food> getAllFood(Integer businessId);
    public Food getFood(Integer foodId);
}
