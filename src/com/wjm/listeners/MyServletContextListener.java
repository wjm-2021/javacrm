package com.wjm.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //创建一个map，key为用户名，value为与用户绑定的session对象
        Map<String, HttpSession> map = new HashMap<>();
        //获取到全局域
        ServletContext servletContext = servletContextEvent.getServletContext();
        //将map放入到全局域对象
        servletContext.setAttribute("map",map);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
