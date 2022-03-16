package com.fc.dao.impl;

import com.fc.dao.UserDao;
import com.fc.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
//在括号可以自动命名id
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAll() {
        ArrayList<User> users = new ArrayList<>();

        users.add(new User(1,"12","12"));
        users.add(new User(2,"21","21"));
        users.add(new User(3,"我是密码","不告诉你"));
        return users;
    }
}
