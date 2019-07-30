package com.sspu.dao;

import com.sspu.model.User;

public class UserDaoImpl implements IUserDao{
    @Override
    public void add(User user) {
        System.out.println("dao 添加用户:" + user);
    }
}
