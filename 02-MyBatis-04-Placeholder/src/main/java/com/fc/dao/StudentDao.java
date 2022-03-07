package com.fc.dao;

import com.fc.entity.Student;

import java.util.List;

public interface StudentDao {
    //查询指定年龄的学生信息
    List<Student> findByAge(String age);

    //查询指定id的学生信息
    List<Student> findById(String id);
}
