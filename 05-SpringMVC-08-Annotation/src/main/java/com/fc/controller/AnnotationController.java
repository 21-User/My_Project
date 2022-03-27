package com.fc.controller;

import com.fc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("annotation")
public class AnnotationController {
    @RequestMapping("tesRequestParam")
    public String testRequestParam(@RequestParam(value = "userId",required = true,defaultValue = "1") String id) {
        System.out.println("获取参数的id为:" + id);

        return "/success.jsp";
    }

    @RequestMapping("page")
    public String page(@RequestParam(value = "pageNo",defaultValue = "1")Integer pageNo,
                       @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize) {
        System.out.println("当前页:" + pageNo + ",每页显示多少条数据: " + pageSize);

        return "/success.jsp";
    }

    @GetMapping(value = "user/{id}")
    public String getUser(@PathVariable("id") Integer id) {
        System.out.println("查询学生：" + id);
        return "/success.jsp";
    }

    @DeleteMapping(value = "user/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        System.out.println("删除学生：" + id);
        return "/success.jsp";
    }

    @PostMapping(value = "user/{id}")
    public String addUser(@PathVariable("id") Integer id) {
        System.out.println("添加学生：" + id);
        return "/success.jsp";
    }

    @PutMapping(value = "user/{id}")
    public String updateUser(@PathVariable("id") Integer id) {
        System.out.println("修改学生：" + id);
        return "/success.jsp";
    }

    @RequestMapping("testJson")
    public String testJson(@RequestBody String json) {
        System.out.println(json);

        return "/success.jsp";
    }

    @RequestMapping("testJsonObject")
    public String testJsonObject(@RequestBody User user) {
        System.out.println(user);

        return "/success.jsp";
    }

}
