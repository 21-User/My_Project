package com.fc.test;

import com.fc.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CreateTest {
    @Test
    public void testStatic() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student student3 = context.getBean("student3", Student.class);

        System.out.println(student3);
    }

    @Test
    public void testFactory() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student student2 = context.getBean("student3",Student.class);

        System.out.println(student2);
    }

    @Test
    public void testConstructor() {
        //获取容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //获取对象
        Student student = context.getBean("student", Student.class);

        System.out.println(student);
    }
}
