package com.element.Controller;

import com.element.Entity.po.Cart;
import com.element.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping(value = "addCarts", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String addCarts(@RequestBody List<Cart> cartLists){
        cartService.addCart(cartLists);
        return "success";
    }
}
