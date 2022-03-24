package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping(path = "testPath")
    public void testPath(String name, Integer age) {
        System.out.println(name + "||" + age);
    }

    @RequestMapping(params = {"name","age"},path = "testValue")
    public void testValue(String name, Integer age) {
        System.out.println(name + "||" + age);
    }


}
