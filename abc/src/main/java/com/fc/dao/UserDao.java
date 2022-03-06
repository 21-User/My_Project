package com.fc.dao;

import com.fc.entity.User;

import java.util.List;

public interface UserDao {
    User findById();

    List<User> findAll();

    User findUserById(Integer id);
}
