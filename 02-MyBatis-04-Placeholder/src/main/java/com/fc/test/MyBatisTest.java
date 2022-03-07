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
    public void testFindById() {
        try {
            //读取配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //构建会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            //获取连接
            SqlSession sqlSession = factory.openSession();

            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

            List<Student> students = studentDao.findById("1 or 1=1");

            for (Student student : students) {
                System.out.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindByAge() {
        SqlSession sqlSession = null;
        try {
            //读取配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //创建会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            //获取连接
            sqlSession = factory.openSession();

            //通过反射获取实体类
            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

            //调用
            List<Student> students = studentDao.findByAge("28 or 1=1");

            for (Student student : students) {
                System.out.println(student);
            }

            //提交事务
            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if (sqlSession !=null) {
                sqlSession.close();
            }
        }
    }
}
