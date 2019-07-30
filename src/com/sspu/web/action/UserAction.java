package com.sspu.web.action;

import com.sspu.model.User;
import com.sspu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserAction {

    private IUserService userService;

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public void save(User user){
        System.out.println("action save方法 ");
        userService.add(user);
    }
}
