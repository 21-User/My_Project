package com.fc.controller;

import com.sun.org.apache.xml.internal.security.Init;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserController extends HttpServlet {
    public UserController() {
        System.out.println("构造方法被执行");
    }

    @Override
    public void init() throws ServletException {
        String username = getInitParameter("username");

        System.out.println(username);

        String password = getInitParameter("password");

        System.out.println(password);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello Spring");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
