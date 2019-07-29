package com.sspu.test;

import com.sspu.service.IUserService;
import com.sspu.service.UserSereviceFactory1;
import com.sspu.service.UserSereviceFactory2;
import com.sspu.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

    @Test
    public void test1(){
        //以前用UserService方式,自己创建对象
        IUserService userSerivce = new UserServiceImpl();
        userSerivce.add();

        //现在使用UserService方式从spring容器获取
        //1.加载beans.xml 这个spring的配置文件,内部就会创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //2.从spring容器获取 userSerivce对象
        IUserService userSerivce1 = (IUserService) context.getBean("userService");
        userSerivce1.add();

        IUserService userSerivce2 = (IUserService) context.getBean("userService");
        userSerivce2.add();

        System.out.println(userSerivce1);
        System.out.println(userSerivce2);

    }

    /**
     *  Spring容器加载有3种方式
     *  1. BeanFactory 采取延迟加载，第一次getBean时才会初始化Bean
     *  2. ApplicationContext 即时加载
     *  ApplicationContext是对BeanFactory扩展，提供了更多功能
     *      国际化处理
     *      事件传递
     *      Bean自动装配
     *      各种不同应用层的Context实现
     */
    @Test
    public void test2(){

        //第一种:ClassPathXmlApplicationContext ClassPath类路径加载，指的就是classes路径
        //第一种：最常用,spring的配置文件路径以后就直接放在src
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //第二种方式：文件系统路径获得配置文件【绝对路径】
        //ApplicationContext context = new FileSystemXmlApplicationContext("D:\IDEA-workspace\MyfirstSpring\src\beans.xml");

        //第三种方式:使用BeanFactory(了解)
        //String path = "C:\\Users\\10301\\Desktop\\IDEAWorkspace\\day02-spring-20180425\\src\\com\\gyf\\beans.xml";
        //BeanFactory factory = new XmlBeanFactory(new FileSystemResource(path));
        //IUserService user = (IUserService) factory.getBean("userService");
        //user.add();

        IUserService userSerivce1 = (IUserService) context.getBean("userService");
        userSerivce1.add();


    }

    /**
     *  实例化Bean的三种方式
     *  1. new实现类
     *  2. 静态工厂
     *  3. 实例工厂
     */
    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans3.xml");
        /** 1. new 对象 service*/
        IUserService userService1 = (IUserService) context.getBean("userService1");
//        userService1.add();

        /** 2. 静态工厂 */
//        IUserService userService2 = UserSereviceFactory1.createUserService();

        IUserService userService2 = (IUserService) context.getBean("userService2");
//        userService2.add();

        /** 3. 实例工厂
         * - 创建工厂
         */
//        UserSereviceFactory2 factory2 = new UserSereviceFactory2();
//        IUserService userService3 = factory2.createUserService();

        IUserService userService3 = (IUserService) context.getBean("userService3");
        userService3.add();
    }

    @Test
    public void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans4.xml");

        //从容器获取两个bean
        IUserService userService1 = (IUserService) context.getBean("userService");
        IUserService userService2 = (IUserService) context.getBean("userService");

        System.out.println(userService1);
        System.out.println(userService2);
    }

}
