package com.element.Controller;

import com.element.Entity.User;
import com.element.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User login(@RequestParam("userName") String userName, @RequestParam("password") String password){
        User login = userService.login(userName,password);
        if(login!=null){
            return login;
        }else{
            return null;
        }
    }

    //注册功能
    @PostMapping("/register")
    public ModelAndView register(@RequestParam("userId") String userId, @RequestParam("userName")
            String userName, @RequestParam("password") String password,@RequestParam("userSex") int userSex, @RequestParam("userImg")
            String userImg, @RequestParam("delTag") int delTag){
        ModelAndView mv = new ModelAndView();
        //用户或密码为空的条件判断
        if(userId.isEmpty()||userName.isEmpty()||password.isEmpty()){
            mv.setViewName("register");
            mv.addObject("tip1","用户或密码不能为空");
            return mv;
        }
        //判断是否取到用户，如果没有就保存在数据库中
        User user= userService.findUserByUserName(userName);
        if(user == null){
            User register=new User();
            register.setUserId(userId);
            register.setUserName(userName);
            register.setPassword(password);
            register.setUserSex(userSex);
            register.setUserImg(userImg);
            register.setDelTag(delTag);
            userService.save(register);
            mv.setViewName("success");
        }
        else {
            mv.setViewName("404");
        }
        return mv;
    }

}
