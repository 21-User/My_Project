package com.fc.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest3 {
    @Test
    public void test3() {
        try {
            //将配置文件中的内容读取到流中
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //获取mybatis核心类对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //通过会话工厂获取连接
            SqlSession sqlSession = sqlSessionFactory.openSession();

            Object one = sqlSession.selectOne("StudentMapper.select");

            System.out.println(one);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
