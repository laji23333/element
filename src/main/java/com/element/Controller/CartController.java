package com.element.Controller;

import com.element.Entity.po.Cart;
import com.element.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/addCarts")
    public String addCarts(){
        List lists = new ArrayList();
        Cart cart1 = new Cart(1,10001,"11111111111",2);
        Cart cart2 = new Cart(2,10001,"11111111111",2);
        Cart cart3 = new Cart(3,10001,"11111111111",2);
        lists.add(cart1);
        lists.add(cart2);
        lists.add(cart3);
        cartService.addCart(lists);
        return "success";
    }
}
