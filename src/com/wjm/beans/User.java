package com.wjm.beans;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.HashMap;
import java.util.Map;

public class User implements HttpSessionBindingListener {
    private String name;
    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        //获取当前session对象
        HttpSession session = httpSessionBindingEvent.getSession();
        //获取全局域对象
        ServletContext servletContext = session.getServletContext();
        //从全局中获取map
        Map<String, HttpSession> map = (Map<String, HttpSession>) servletContext.getAttribute("map");
        //将当前用户名与session放入到map
        map.put(name,session);
        //将map写入到全局域中
        servletContext.setAttribute("map",map);
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}
