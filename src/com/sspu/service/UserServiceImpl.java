package com.sspu.service;

import com.sspu.dao.IUserDao;
import com.sspu.model.User;
import org.springframework.stereotype.Component;


@Component("userService")
// 或者 @Component
public class UserServiceImpl implements IUserService {

    private IUserDao userDao;
    private String name = null;

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void add() {
        System.out.println("创建用户...." + name);
    }

    public UserServiceImpl() {
        System.out.println("UserServiceImpl（）调用了");
    }

    @Override
    public void add(User user) {
        System.out.println("service 添加用户:" + user);
        //调用dao
        userDao.add(user);
    }

}


