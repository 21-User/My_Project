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

public class MyBatisTestFindUserById {
    @Test
    public void testUserById() {
        try {
            //读取配置文件到流中
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //创建会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            //获取连接
            SqlSession sqlSession = factory.openSession();

            //通过反射获取接口的实现类
            UserDao userDao = sqlSession.getMapper(UserDao.class);

            //调用
            User user = userDao.findUserById(3);

            //输出
            System.out.println(user);

            //提交事务
            sqlSession.commit();

            //关闭资源
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
