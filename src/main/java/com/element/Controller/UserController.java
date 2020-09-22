package com.element.Controller;

import com.element.Entity.po.User;
import com.element.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getData")
    public List<User> test(){
        List<User> users = userService.getAllUser();
        return users;
    }
}
