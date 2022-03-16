package com.fc.test;

import com.fc.entity.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifecycleTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student student = context.getBean("student", Student.class);

        System.out.println(student);

        context.close();
    }
}
