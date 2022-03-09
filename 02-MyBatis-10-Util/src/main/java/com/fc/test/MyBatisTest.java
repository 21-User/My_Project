package com.fc.test;

import com.fc.util.MyBatisUtil;
import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import org.junit.Test;

import java.util.List;

public class MyBatisTest {
    @Test
    public void testFindAll() {
        try {
            StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

            List<Student> students = studentDao.findAll();

            for (Student student : students) {
                System.out.println(student);
            }

            //成功的话就提交
            MyBatisUtil.commit();
        } catch (Exception e) {
            //失败就回滚
            MyBatisUtil.rollback();
            e.printStackTrace();
        }

    }

}
