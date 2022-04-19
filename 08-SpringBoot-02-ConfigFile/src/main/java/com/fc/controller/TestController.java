package com.fc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${user.username}")
    private String username;
    @Value("${user.age}")
    private int age;


    @RequestMapping("test")
    public String test() {
        return username+":"+age;
    }
}
