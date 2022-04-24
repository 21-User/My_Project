package com.fc;

import com.fc.config.TestConfig;
import com.fc.entity.Car;
import com.fc.entity.Cat;
import com.fc.entity.Person;
import com.fc.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        //ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();

        /**
         * 用于启动SpringBoot项目
         *
         * 获取容器spring容器
         */
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);

        //从容器中获取bean对象
        TestConfig testConfig = run.getBean(TestConfig.class);

        System.out.println("hashcode：" + testConfig.hashCode());
        System.out.println("地址：" + testConfig);

        User user = run.getBean(User.class);
        User user1 = run.getBean(User.class);

        System.out.println("容器中的对象" +(user == user1));

        User user2 = testConfig.getUser();
        User user3 = testConfig.getUser();

        System.out.println("构造方法创建的对象" + (user2 == user3));

        System.out.println("容器中和构造方法" + (user == user3));

        System.out.println("---------------");

        Person person = run.getBean(Person.class);

        Car car = run.getBean(Car.class);

        //Car newCar = testConfig.getCar();
        //
        //person.setCar(newCar);

        System.out.println("人的车和容器中的车：" + (person.getCar() == car));

        Car carCar = run.getBean("car2", Car.class);

        System.out.println(carCar);

        System.out.println("--------------");

        Cat cat = run.getBean("com.fc.entity.Cat", Cat.class);

        System.out.println("从容器中拿到的猫：" + cat);
    }

}
