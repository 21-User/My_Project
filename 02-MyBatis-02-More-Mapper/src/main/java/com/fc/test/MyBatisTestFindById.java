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

public class MyBatisTestFindById {
    @Test
    public void testFindById() {

        try {
            //将配置文件读取到流中
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //构建会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            //获取连接
            SqlSession sqlSession = factory.openSession();

            //通过反射获取接口的实体类
            UserDao userDao = sqlSession.getMapper(UserDao.class);

            //调用方法
            User user = userDao.findById();

            //输出
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
