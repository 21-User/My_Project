package com.fc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class TestConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 设置映射的路径，当我们访问到/ 的时候，自动跳转至hello/home.html
        registry.addViewController("/").setViewName("forward:/testIndex.html");

        // 设置当前注册器优先级
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
