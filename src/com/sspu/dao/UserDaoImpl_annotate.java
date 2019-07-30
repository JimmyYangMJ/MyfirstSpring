package com.sspu.dao;

import com.sspu.model.User;
import org.springframework.stereotype.Repository;

/**
 * 使用注解
 */
@Repository
public class UserDaoImpl_annotate implements IUserDao{
    @Override
    public void add(User user) {
        System.out.println("dao 添加用户:" + user);
    }
}
