package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.MyBatisUtil;
import org.junit.Test;
import java.util.List;

public class DynamicSQLTest {
    @Test
    public void testDeleteMore() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        //参数可以是0个，1个，或者多个
        int affectRows = studentDao.deleteMore(11);

        MyBatisUtil.commit();
    }

    @Test
    public void testUpdateWithTrim() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();

        student.setId(10);
        student.setInfo("骆驼直哆嗦啊");

        int affectRows = studentDao.updateWithTrim(student);

        MyBatisUtil.commit();
    }

    @Test
    public void testFindBYStudentWithTrim() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();

        student.setId(11);
        student.setAge((byte) 20);
        student.setGender("男");
        student.setName("李四");
        student.setInfo("张四就是张三他哥");

        List<Student> students = studentDao.findBYStudentWithTrim(student);

        for (Student student1 : students) {
            System.out.println(student);
        }

    }

    @Test
    public void testUpdate() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();

        student.setId(8);
        student.setInfo("这瓜保熟吗");

        int affectRows = studentDao.update(student);

        MyBatisUtil.commit();
    }

    @Test
    public void testFindByStudent() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        Student student = new Student();
        student.setGender("女");
        student.setAge((byte) 28);
        student.setId(6);

        List<Student> students = studentDao.findByStudent(student);

        for (Student student1 : students) {
            System.out.println(student1);
        }
    }

    @Test
    public void testFindKeyWord() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        List<Student> students = studentDao.findByKeyword("%张%",20);

        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testFindAll() {
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);

        List<Student> students = studentDao.findAll();

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
