package com.element.Service.Imp;

import com.element.Mapper.UserMapper;

import com.element.Entity.po.User;
import com.element.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public User login(String userName, String password) {
        return userMapper.login(userName,password);
    }

    @Override
    public User findUserByUserId(String userId) {
        return userMapper.findUserByUserId(userId);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userMapper.findUserByUserName(userName);
    }

    @Override
    public void save(User user) {
    }

    @Override
    public Integer checkUser(String userName,String password){
        for (User user:userMapper.getAllUser()){
            if (user.getUserName().equals(userName)){
                if (user.getPassword().equals(password)){
                    return 1;       //全正确
                }else{
                    return 2;       //密码错误
                }
            }
        }
        return 0;                   //用户不存在
    }
}
