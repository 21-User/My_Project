package com.fc.controller;

import com.fc.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private Student student;

    @RequestMapping("getStudent")
    public Student getStudent() {
        return student;
    }

    @RequestMapping("profile")
    public String test() {
        return "测试多环境配置";
    }
}
