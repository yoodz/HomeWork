package com.zzuli.home.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zzuli.home.dao.UserDao;
import com.zzuli.home.model.User;

@Service("userService")
public class UserService {

    @Resource
    private UserDao userDao;

    public User validate (User user) {
        
        User user2 = userDao.getByUserName(user.getUserName());
        if (user2 == null) {
            return null;
        }
        if (user2.getPassword().equals(user.getPassword()) || user2.getPassword() == user.getPassword()) {
            return user2;
        } else {
            return null;
        }
    }
}
