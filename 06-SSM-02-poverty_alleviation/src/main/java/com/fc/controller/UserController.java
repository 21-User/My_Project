package com.fc.controller;

import com.fc.dao.dto.UserResponseDto;
import com.fc.entity.User;
import com.fc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("list")
    public UserResponseDto list(@RequestParam(value = "pageNo") int pageNo,
                                @RequestParam(value = "pageSize") int pageSize,
                                @RequestParam(value = "id", required = false) Long id) {
        return userService.list(pageNo, pageSize, id);
    }

    @RequestMapping("update")
    public Map<String, Object> update(User user) {
        return userService.update(user);
    }

    @RequestMapping("del")
    public Map<String, Object> del(Long id) {
        return userService.del(id);
    }

}
