package com.fc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
@AllArgsConstructor
//@NoArgsConstructor
//把当前类的对象放到容器中
@Component
public class User {
    @Value("6")
    private Integer id;
    @Value("啊对对对666")
    private String username;
    @Value("123456")
    private String password;

    public User() {
        System.out.println("无参构造方法");
    }
    @PostConstruct
    public void play() {
        System.out.println("劳逸结合");
    }
    @PreDestroy
    public void eat() {
        System.out.println("今天中午没吃饭");
    }

}
