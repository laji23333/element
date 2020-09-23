package com.element.Mapper;

import com.element.Entity.po.Cart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    void addCart(List<Cart> carts);
}
