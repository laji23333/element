package com.element.Service;

import com.element.Entity.po.Food;

import java.util.List;

public interface FoodService {
    List<Food> getAllFood(Integer businessId);
    Food getFoodByFoodId(Integer foodId);
}
