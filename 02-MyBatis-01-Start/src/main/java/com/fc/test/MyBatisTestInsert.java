package com.fc.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hamcrest.Factory;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTestInsert {
    @Test
    public void testInsert() {
        try {
            //读取配置文件中的内容到流中
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //获取mybatis核心类对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession = sqlSessionFactory.openSession();

            //执行sql语句获取受影响的行数
            int affectRows = sqlSession.insert("StudentMapper.insert");

            System.out.println("受影响的行数：" +  affectRows);

            //提交事务
            sqlSession.commit();

            //关闭资源
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
