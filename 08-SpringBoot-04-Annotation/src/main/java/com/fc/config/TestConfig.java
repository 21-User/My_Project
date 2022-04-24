package com.fc.config;

import com.fc.entity.Car;
import com.fc.entity.Person;
import com.fc.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class TestConfig {
    @Bean({"car", "car1", "car2"})
    public Car getCar() {
        return new Car("保时捷", "粉色");
    }

    @Bean
    // 参数会自动从容器中去获取
    public Person getPerson(Car car) {
        return new Person("甲赛", getCar());
    }

    public TestConfig() {
        System.out.println("无参构造方法");
    }

    // 将User类的对象注入到容器中
    @Bean
    //多例模式
    //@Scope("prototype")
    public User getUser() {
        return new User();
    }

    public String test() {
        System.out.println("测试Configuration注解");
        return "使用Configuration的为配置类";
    }
}
