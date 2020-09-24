package com.element.Controller;

import com.element.Entity.po.Cart;
import com.element.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/addCarts")
    public String addCarts(@RequestParam("cartLists")List<Cart> cartLists){
        cartService.addCart(cartLists);
        return "success";
    }
}
