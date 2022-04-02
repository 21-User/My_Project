package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("add")
    public Map<String, Object> add(User user) {
        return userService.add(user);
    }

    @RequestMapping("list")
    public List<UserService> list(User user) {
        return userService.list(user);
    }
}
