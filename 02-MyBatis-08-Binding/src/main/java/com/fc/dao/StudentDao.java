package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    //序号参数绑定【arg从0开始】
    Student findByIdAndName(Integer id , String name);

    //序号参数绑定【param从1开始】
    Student findByIdAndAge(Integer id , Integer age);

    //使用@Param注解进行参数绑定
    Student findByNameAndAge(@Param("name") String name, @Param("age") Integer age);

    //使用map参数绑定
    int insert(Map<String, Object> map);

    //使用对象参数绑定
    int insertStudent(Student student);
}
