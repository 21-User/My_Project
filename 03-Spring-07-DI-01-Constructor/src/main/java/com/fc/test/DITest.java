package com.fc.test;

import com.fc.entity.Car;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DITest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Car car = context.getBean(Car.class);

        System.out.println(car);
    }

}
