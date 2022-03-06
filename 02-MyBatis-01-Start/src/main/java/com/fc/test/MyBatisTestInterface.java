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

public class MyBatisTestInterface {
    @Test
    public void testInterface() {
        try {
            //将配置文件中的内容读取到流中
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //构建会话工厂
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //获取连接
            SqlSession sqlSession = sqlSessionFactory.openSession();

            //通过反射获取接口的实现类
            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

            Student student = studentDao.findById();

            System.out.println(student);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
