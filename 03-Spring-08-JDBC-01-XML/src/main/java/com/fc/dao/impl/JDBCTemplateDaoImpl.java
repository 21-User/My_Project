package com.fc.dao.impl;

import com.fc.entity.User;
import com.fc.test.JdbcTemplateTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JDBCTemplateDaoImpl {
    private JdbcTemplate jdbcTemplate;

    public List<User> findAll() {
        String sql = "select * from User";

        // query方法需要传递两个参数
        // sql
        // BeanPropertyRowMapper的匿名对象
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));

        return users;
    }

    public User findById(Integer id) {
        String sql = "select * from User where id = ?";

        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class),id);

        return users.get(0);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
