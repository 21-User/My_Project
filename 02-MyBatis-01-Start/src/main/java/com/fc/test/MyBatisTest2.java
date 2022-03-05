package com.fc.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest2 {
    @Test
    public void test2() {
        try {
            //读取配置文件中的内容到流中
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //获取mybatis核心类对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //用过回话工厂获取连接
            SqlSession sqlSession = sqlSessionFactory.openSession();

            Object one = sqlSession.selectOne("StudentMapper.select");

            System.out.println(one);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
