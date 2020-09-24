package com.element.Controller;

import com.alibaba.fastjson.JSONObject;
import com.element.Entity.po.User;
import com.element.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;


@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String login(@RequestBody User userPO, HttpServletRequest request){

        int flag = userService.checkUser(userPO.getUserName(),userPO.getPassword());

        if( flag != 0) {
            if (flag == 1){
                User user = userService.login(userPO.getUserName(),userPO.getPassword());
                //将id存入session
                request.getSession().setAttribute("userId",user.getUserId());
                JSONObject result = new JSONObject();
                result.put("status", "success");
                result.put("detail","登录成功！");
                result.put("userId",request.getSession().getAttribute("userId"));
                return result.toJSONString();
            }else{
                JSONObject result = new JSONObject();
                result.put("status", "failure");
                result.put("detail","密码错误，登录失败！");
                return result.toJSONString();
            }
        }else{
            JSONObject result = new JSONObject();
            result.put("status", "failure");
            result.put("detail","账号不存在，请先注册账号！");
            return result.toJSONString();
        }


    }
    //注册功能
    @RequestMapping(value = "register", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String register(@RequestBody User userPO){
        JSONObject result = new JSONObject();
        //用户或密码为空的条件判断
        if(userPO.getUserId().isEmpty()||userPO.getPassword().isEmpty()||userPO.getPassword().isEmpty()){
            JSONObject result1 = new JSONObject();
            result1.put("status","failure");
            result1.put("detail","手机号或用户名或密码不能为空");
            return  result1.toJSONString();
        }
        //判断是否取到用户，如果没有就保存在数据库中
        User user= userService.findUserByUserName(userPO.getUserName());
        User user1 = userService.findUserByUserId(userPO.getUserId());
        if(user == null && user1 == null){
            User register=new User();
            register.setUserId(userPO.getUserId());
            register.setUserName(userPO.getUserName());
            register.setPassword(userPO.getPassword());
            register.setUserSex(userPO.getUserSex());
            register.setDelTag(1);
            userService.save(register);
            result.put("status","success");
            result.put("detail",register);
        }else {
            result.put("status","failure");
            result.put("detail","注册失败！");
        }
        return  result.toJSONString();
    }
}
