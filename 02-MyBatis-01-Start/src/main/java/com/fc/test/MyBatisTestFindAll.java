package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTestFindAll {
    @Test
    public void testFindAll() {
        try {
            //将配置文件读取到流中
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //构建会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            //获取会话连接
            SqlSession session = factory.openSession();

            //获取接口的实现类
            StudentDao studentDao = session.getMapper(StudentDao.class);

            //调用方法
            List<Student> students = studentDao.findAll();

            //输出
            System.out.println(students);

            //提交事务
            session.commit();

            //关闭资源
            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
