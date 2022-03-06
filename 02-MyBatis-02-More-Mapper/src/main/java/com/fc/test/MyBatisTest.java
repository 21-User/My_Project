package com.fc.test;

import com.fc.dao.UserDao;
import com.fc.entity.User;
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
    public void testFindUserById() {
        try {
            //读取配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //创建会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            //获取连接
            SqlSession sqlSession = factory.openSession();

            //通过反射获取实体类
            UserDao userDao = sqlSession.getMapper(UserDao.class);

            User user = userDao.findUserById(4);

            System.out.println(user);

            //提交事务
            sqlSession.commit();

            //关闭资源
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindById() {
        try {
            //读取配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //创建会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            //获取连接
            SqlSession sqlSession = factory.openSession();

            //通过反射获取的实体类
            UserDao userDao = sqlSession.getMapper(UserDao.class);

            //调用方法
            User user = userDao.findById();

            //输出
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAll() {
        try {
            //读取配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //创建会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            //获取连接
            SqlSession openSession = factory.openSession();

            //通过反射获取实体类
            UserDao userDao = openSession.getMapper(UserDao.class);

            List<User> users = userDao.findAll();

            System.out.println(users);

            //提交事务
            openSession.commit();

            //关闭资源
            openSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
