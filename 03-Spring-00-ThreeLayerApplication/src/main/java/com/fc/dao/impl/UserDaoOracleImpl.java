package com.fc.dao.impl;

import com.fc.dao.UserDao;

public class UserDaoOracleImpl implements UserDao {
    @Override
    public void useDateBase() {
        System.out.println("使用了Oracle数据库");
    }
}
