package com.sspu.test;

import com.sspu.model.User;
import com.sspu.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 通过 注解 配置类的id
 */
public class Test02 {

    /**
     * @Component
     * 用于配置Bean的 id
     */
    @Test
    public void test10(){

        //注解来取代xml中bean的配置
        /**
         * 1.Spring默认情况下注解不生效，开启注解功能
         * 2.如何开启spring注解功能？
         *   在.xml中配置两行代码
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("beans10.xml");

        /**
        1.如果@Component没配置id,通过类型获取， （反射）
            IUserService service = (IUserService) context.getBean(IUserServiceImpl.class);
         --这个类型可以是接口，还可以是实现类
            IUserService service = (IUserService) context.getBean(IUserService.class);
         */
        /**
         2. 如果@Component("userService),配置了id，就可以通过id来获取
         */
        IUserService service = (IUserService) context.getBean("userService");

        User user = new User();
        user.setUsername("杨明杰");
        service.add(user);

    }
}
