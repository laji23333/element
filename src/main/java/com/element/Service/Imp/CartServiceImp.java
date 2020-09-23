package com.element.Service.Imp;

import com.element.Entity.po.Cart;
import com.element.Mapper.CartMapper;
import com.element.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImp implements CartService {
    @Autowired(required = false)
    private CartMapper cartMapper;

    @Override
    public void addCart(List<Cart> carts) {
        cartMapper.addCart(carts);
    }
}
