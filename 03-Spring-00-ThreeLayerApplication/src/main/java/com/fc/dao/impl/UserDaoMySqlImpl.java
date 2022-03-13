package com.fc.dao.impl;

import com.fc.dao.UserDao;

public class UserDaoMySqlImpl implements UserDao {
    @Override
    public void useDateBase() {
        System.out.println("使用mysql连接数据库");
    }
}
