package com.fc.service;

import com.fc.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    Map<String, Object> add(User user);

    List<UserService> list(User user);
}
