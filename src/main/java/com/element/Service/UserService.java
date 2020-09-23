package com.element.Service;


import com.element.Entity.po.User;

public interface UserService {
    User login(String userName, String password);       //用户登录
    User findUserByUserId(String userId);           //根据用户id查找用户
    User findUserByUserName(String userName);       //根据用户名查找用户
    void save(User user);                           //添加用户
    Integer checkUser(String userName,String password);           //判断用户是否存在/存在密码是否正确

}
