package com.fc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("response")
public class ResponseController {
    @RequestMapping("testVoid")
    public void testVoid() {
        System.out.println("返回值为void,视图无法被解析");
    }

    @RequestMapping("testString")
    public String testString() {
        System.out.println("返回值为String,可以直接进行跳转");

        return "/success.jsp";
    }

    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView() {
        //相当于转发(url路径不会发生改变,携带参数进行传递)
        ModelAndView mv = new ModelAndView();

        //设置模型
        mv.addObject("username","古力娜扎");
        //request.setAttribute("username","古力娜扎");


        //设置视图
        mv.setViewName("/success.jsp");
        //request.getRequestDispatcher("/success.jsp").forward(request,response);

        return mv;
    }

    @RequestMapping("testModelAndView2")
    //从容器中拿到一个对象
    public ModelAndView testModelAndView2(ModelAndView mv) {
        //相当于转发(url路径不会发生改变,携带参数进行传递)
        //设置模型
        mv.addObject("username","迪丽热巴");
        //request.setAttribute("username","迪丽热巴");


        //设置视图
        mv.setViewName("/success.jsp");
        //request.getRequestDispatcher("/success.jsp").forward(request,response);

        return mv;
    }

    @RequestMapping("testModelAndView3")
    //从容器中拿到一个模型
    public String testModelAndView23(Model model) {
        //相当于转发(url路径不会发生改变,携带参数进行传递)
        //设置模型
        model.addAttribute("username","哈哈哈哈");

        //这里有视图了只需要拿到模块就行
        return "/success.jsp";
    }

    @RequestMapping("testVoidForward")
    public void testVoidForward(HttpServletRequest request, HttpServletResponse response) {

        request.setAttribute("username","海绵宝宝");

        try {
            request.getRequestDispatcher("/success.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("testVoidRedirect")
    public void testVoidRedirect(HttpServletResponse response) {

        try {
            response.sendRedirect("/success.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("testStringRedirect")
    public String testStringRedirect() {
        return "redirect:/success.jsp";
    }

    @RequestMapping("testStringForward")
    public String testStringForward(Model model) {
        model.addAttribute("username","汤不理不");

        return "forward:/success.jsp";
    }

    // ResponseBody注解会自动跳过视图解析器
    // 并且返回json类型的数据
    @RequestMapping("testResponseBody")
    @ResponseBody
    public void testResponseBody() {
        System.out.println("测试@ResponseBody注解");
    }

    // ResponseBody注解会自动跳过视图解析器
    // 并且返回json类型的数据
    @RequestMapping("testResponseBodyString")
    @ResponseBody
    public String testResponseBodyString() {
        // 如果直接使用字符串返回就相当于调用
        // resp.getWriter().write("/success.jsp");
        return "/success.jsp";
    }

    @RequestMapping(value = "testHtmlString",produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String testHtmlString() {

        return "<h1 align = 'center' style='color:green'>哈哈哈哈</h1> ";
    }

    @RequestMapping(value = "testJsonString", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String testJsonString() {
        return "{\"username\": \"易烊千玺\", \"password\": \"123456\"}";
    }

    @RequestMapping(value = "testJsonObject", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String testJsonObject() {
        User user = new User();

        user.setName("内卷之王");
        user.setAge(20);
        user.setGender("男");
        user.setBirthday(new Date());
        user.setInfo("打卡机废物狗");

        //获取对象映射器
        ObjectMapper objectMapper = new ObjectMapper();

        //将java对象转为JSON字符串
        String json = null;
        try {
            json = objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(json);

        return json;
    }

    @RequestMapping(value = "testObject", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public User testObject() {
        User user = new User();

        user.setName("内卷之王");
        user.setAge(20);
        user.setGender("男");
        user.setBirthday(new Date());
        user.setInfo("打卡机废物狗");

        return user;
    }

    @RequestMapping(value = "testMap", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Map<String,Object> testMap() {
        User user = new User();

        user.setName("内卷之王");
        user.setAge(20);
        user.setGender("男");
        user.setBirthday(new Date());
        user.setInfo("打卡机废物狗");

        List<String> foods = new ArrayList<>();

        foods.add("老碗面");
        foods.add("米饭");
        foods.add("紫薯丸子");

        Map<String,Object> map = new HashMap<>();

        map.put("code",200);
        map.put("success",true);
        map.put("message","成功了");
        map.put("date",user);
        map.put("foods",foods);

        return map;
    }

}
