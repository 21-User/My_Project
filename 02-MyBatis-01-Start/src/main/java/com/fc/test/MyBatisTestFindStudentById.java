package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTestFindStudentById {
    @Test
    public void testFindStudentById() {

        try {
            //将配置文件读取到流中
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //构建会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            //获取连接
            SqlSession sqlSession = factory.openSession();

            //获取接口的实现类
            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

            //调用方法
            Student student = studentDao.findStudentById(4);

            //输出
            System.out.println(student);

            //提交事务
            sqlSession.commit();

            //关闭资源
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
