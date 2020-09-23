package com.element.Dao;

import com.element.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    public User login(@Param("userName") String userName, @Param("password") String password);
    public User findUserByUserId(String userId);
    public User findUserByUserName(String userName);
    public void save(User user);
}
