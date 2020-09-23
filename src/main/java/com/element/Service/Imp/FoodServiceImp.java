package com.element.Service.Imp;

import com.element.Entity.po.Food;
import com.element.Mapper.FoodMapper;
import com.element.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImp implements FoodService {

    @Autowired(required = false)
    private FoodMapper foodMapper;
    @Override
    public List<Food> getAllFood(Integer businessId) {
        return foodMapper.getAllFood(businessId);
    }

    @Override
    public Food getFoodByFoodId(Integer foodId) {
        return foodMapper.getFood(foodId);
    }


}
