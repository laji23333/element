package com.element.Controller;

import com.alibaba.fastjson.JSONObject;
import com.element.Entity.po.User;
import com.element.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login1(@RequestParam("userName") String userName, @RequestParam("password") String password){
        User login = userService.login(userName,password);
        if(login!=null){
            JSONObject result = new JSONObject();
            result.put("status","success");
            result.put("detail",login);
            return  result.toJSONString();
        }else{
            JSONObject result = new JSONObject();
            result.put("status","failure");
            result.put("detail","账户名或密码错误");
            return  result.toJSONString();
        }
    }
    //注册功能
    @PostMapping("/register")
    public String register(@RequestParam("userId") String userId, @RequestParam("userName")
            String userName, @RequestParam("password") String password,@RequestParam("userSex") int userSex, @RequestParam("userImg")
            String userImg, @RequestParam("delTag") int delTag){
        JSONObject result = new JSONObject();
        //用户或密码为空的条件判断
        if(userId.isEmpty()||userName.isEmpty()||password.isEmpty()){
            JSONObject result1 = new JSONObject();
            result1.put("status","failure");
            result1.put("detail","用户名或密码不能为空");
            return  result1.toJSONString();
        }
        //判断是否取到用户，如果没有就保存在数据库中
        User user= userService.findUserByUserName(userName);
        User user1 = userService.findUserByUserId(userId);
        if(user == null && user1 == null){
            User register=new User();
            register.setUserId(userId);
            register.setUserName(userName);
            register.setPassword(password);
            register.setUserSex(userSex);
            register.setUserImg(userImg);
            register.setDelTag(delTag);
            userService.save(register);
            result.put("status","success");
            result.put("detail",register);
        }else {
            result.put("status","failure");
            result.put("detail","还没有商家");
        }
        return  result.toJSONString();
    }
}
