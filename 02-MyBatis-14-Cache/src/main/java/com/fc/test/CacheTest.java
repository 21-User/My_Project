package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class CacheTest {
    @Test
    public void testUpdate() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student1 = studentDao.findById(8);

            //修改
            Student student = new Student();
            student.setId(10);
            student.setInfo("草骆驼，直哆嗦");
            studentDao.update(student);

            Student student2 = studentDao.findById(8);

            System.out.println(student1 == student2);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testFIndById() {
        try {
            //一级缓存只存在同一个SqlSession中
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = factory.openSession();

            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student1 = studentDao.findById(8);

            //清空缓存
            //session.clearCache();

            //commit也可以清楚缓存
            //session.commit();

            //回滚可以刷新缓存
            //session.rollback();

            Student student2 = studentDao.findById(8);

            System.out.println(student1 == student2);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
