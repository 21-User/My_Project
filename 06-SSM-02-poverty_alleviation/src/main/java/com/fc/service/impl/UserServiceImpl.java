package com.fc.service.impl;

import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, Object> add(User user) {
        System.out.println(user);
        int affectRows = userMapper.insertSelective(user);

        Map<String, Object> map = new HashMap<>();

        map.put("message", "用户添加失败！");
        map.put("code", 400);
        map.put("success", false);
        map.put("data", "失败");

        if (affectRows > 0) {
            map.put("message", "用户添加成功！");
            map.put("code", 200);
            map.put("success", true);
            map.put("data", null);

        }
        return map;
    }

    @Override
    public List<UserService> list(User user) {

        return null;
    }
}
