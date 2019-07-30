package com.sspu.web.action;

import com.sspu.model.User;
import com.sspu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
@Scope("prototype") //  多例
public class UserAction_annotate {

    @Autowired
    /** 根据指定的id注入属性 ,
    *  这里调用了UserServiceImpl_annotate类中的
     *  @Service("myUserService")注解中的id，避免错误的调用了其他实现类
    */
    @Qualifier("myUserService")
    //@Resource(name = "myUserService")//等效于前面两行代码【用的比较少】
    private IUserService userService;

    public void save(User user){
        System.out.println("action save方法 ");
        userService.add(user);
    }
}
