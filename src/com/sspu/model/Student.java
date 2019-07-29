package com.sspu.model;

public class Student {

    private String username;
    private String password;
    private int age;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * 构造方法
     */
    public Student() {
    }

    public Student(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Student(String username, int age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
