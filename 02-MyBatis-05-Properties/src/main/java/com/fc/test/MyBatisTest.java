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
import java.util.List;

public class MyBatisTest {
    @Test
    public void testFindAll() {
        try {
            //读取配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //创建会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            //获取连接
            SqlSession sqlSession = factory.openSession();

            //通过映射获取实体类
            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

            //调用
            List<Student> students = studentDao.findAll();

            for (Student student : students) {
                System.out.println(student);
            }
            sqlSession.commit();

            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
