package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("jsp")
public class JSPController {

    @RequestMapping("123")
    public ModelAndView getJsp(ModelAndView mv) {

        mv.addObject("username", "昨日青空");
        mv.setViewName("login");

        return mv;
    }
}
