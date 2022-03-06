package com.fc.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTestInsert {
    @Test
    public void testInsert() {
        try {
            //读取配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //创建会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            //获取连接
            SqlSession sqlSession = factory.openSession();

            //获取受影响的行数
            int affectRows = sqlSession.insert("UserMapper.insert");

            //受影响的行数
            System.out.println("受影响的行数为：" + affectRows);

            //提交事务
            sqlSession.commit();

            //关闭资源
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
