package com.fc.service.impl;

import com.fc.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("添加学生信息");
    }

    @Override
    public void update() {
        int a = 1/0;
        System.out.println("修改学生信息");
    }
}
