package com.sspu.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class User implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {

    private String username;

    private String password;

    public User(){
        System.out.println("1. 实例化....");
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        System.out.println("2. 赋值属性:" + password);
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("3. 设置bean名字:" + s);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        //把工厂生成的对象，放进容器
        System.out.println("4. bean工厂生成对象:" + beanFactory);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("6. 属性赋值完成...");
    }

    public  void myInit(){
        System.out.println("7. 自定义的初始化方法...");
    }

    @Override
    public void destroy() throws Exception {
        //资源释放
        System.out.println("9. bean被销毁");
    }

    public void myDestroy(){
        //资源释放
        System.out.println("10.自定义的销毁方法");
    }
}
