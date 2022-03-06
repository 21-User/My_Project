package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.dao.UserDao;
import com.fc.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisInsertTest {
    @Test
    public void testInsert() {
        try {
            //读取配置文件到流中
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //创建会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            //获取连接
            SqlSession sqlSession = factory.openSession();

            //执行SQL语句获取受影响的行数
            int affectRows = sqlSession.insert("UserMapper.insert");

            //输出
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
