package com.sspu.service;

import com.sspu.dao.IUserDao;
import com.sspu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service("myUserService")
public class UserServiceImpl_annotate implements IUserService {

    @Autowired /** Spring会自动注入userDao赋值， 不用提供setter方法*/
    private IUserDao userDao;
    @Override
    public void add(User user) {
        System.out.println("service 添加用户:" + user);
        //调用dao
        userDao.add(user);
    }

    private String name = null;

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


}


