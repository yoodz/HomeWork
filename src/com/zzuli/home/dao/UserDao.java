package com.zzuli.home.dao;

import org.springframework.stereotype.Repository;

import com.zzuli.home.model.User;

@Repository("userDao")
public class UserDao extends BaseDao<User, Integer> {

    private static final String CLASS_NAME = User.class.getName();
    private static final String SQL_ID_GET_BY_USER_NAME = ".getByUserName";
    
    public User getByUserName(String name) {
        return getSqlSession().selectOne(CLASS_NAME + SQL_ID_GET_BY_USER_NAME, name);
    }

}
