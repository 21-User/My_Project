package com.fc.service.impl;

import com.fc.dao.dto.UserResponseDto;
import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, Object> add(User user) {
        int affectedRows = userMapper.insertSelective(user);

        Map<String, Object> map = new HashMap<>();

        map.put("message", "用户添加失败！");
        map.put("code", 400);
        map.put("success", false);
        map.put("data", "失败");


        if (affectedRows > 0) {
            map.put("message", "用户添加成功！");
            map.put("code", 200);
            map.put("success", true);
            map.put("data", user);

        }

        return map;
    }

    @Override
    public UserResponseDto list(int pageNo, int pageSize, Long id) {

        //第几页  有几条内容
        PageHelper.startPage(pageNo, pageSize);
        List<User> list = new ArrayList<>();

        if (id != null) {
            list.add(userMapper.selectByPrimaryKey(id));
        } else {
            list = userMapper.selectAll();
        }

        return UserResponseDto.getUserMessageSuccess(new PageInfo<>(list));
    }

    @Override
    public Map<String, Object> update(User user) {
        int affectedRows = userMapper.updateByPrimaryKey(user);

        Map<String, Object> map = new HashMap<>();

        map.put("message", "用户修改失败！");
        map.put("code", 404);
        map.put("success", false);
        map.put("data", "失败");


        if (affectedRows > 0) {
            map.put("message", "用户修改成功！");
            map.put("code", 200);
            map.put("success", true);
            map.put("data", user);

        }

        return map;
    }

    @Override
    public Map<String, Object> del(Long id) {
        int affectedRows = userMapper.deleteByPrimaryKey(id);

        Map<String, Object> map = new HashMap<>();

        if (affectedRows > 0) {
            map.put("message", "用户删除成功！");
            map.put("code", 200);
            map.put("success", true);
            map.put("data", null);

        } else {
            map.put("message", "用户删除失败！");
            map.put("code", 404);
            map.put("success", false);
            map.put("data", "失败");
        }

        return map;
    }
}
