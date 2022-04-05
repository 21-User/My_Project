package com.fc.service;

import com.fc.dao.dto.UserResponseDto;
import com.fc.entity.User;

import java.util.Map;

public interface UserService {
    Map<String, Object> add(User user);

    UserResponseDto list(int pageNo, int pageSize, Long id);

    Map<String, Object> update(User user);

    Map<String, Object> del(Long id);

}
