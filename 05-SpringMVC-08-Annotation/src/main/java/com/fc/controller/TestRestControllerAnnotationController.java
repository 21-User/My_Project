package com.fc.controller;

import com.fc.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("controller")
public class TestRestControllerAnnotationController {
    @RequestMapping("getUser")
    private User getUser() {
        return new User("玛卡巴卡",21,"男",new Date(),"吗卡巴拉卡卡坎坎坷坷");
    }
}
