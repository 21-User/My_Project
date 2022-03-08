package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    //对象参数绑定添加
    int insert(Student student);

    //使用注解参数绑定删除
    int delete(@Param("id") Integer id);

    //使用对象参数绑定更改学生信息
    int update(Student student);

    //查询全部
    List<Student> findAll();

    //使用注解参数绑定根据id查询学生信息
    Student findById(@Param("id") Integer id);

    //使用注解参数绑定，进行模糊查询
    List<Student> findByKeyWord(@Param("keyword") String keyword);

    // 主键回填
    int getIncrement(Student student);
}
