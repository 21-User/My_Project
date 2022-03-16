package com.fc.test;

import com.fc.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    @Test
    public void test() {
        ApplicationContext ApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student student = ApplicationContext.getBean("student", Student.class);
        Student student1 = ApplicationContext.getBean("student", Student.class);

        System.out.println(student1);
        System.out.println(student);

        System.out.println(student == student1);
    }
}
