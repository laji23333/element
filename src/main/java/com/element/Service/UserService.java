package com.element.Service;

import com.element.Entity.User;

public interface UserService {
    public User login(String userName, String password);
    public User findUserByUserId(String userId);
    public User findUserByUserName(String userName);
    public void save(User user);
}
