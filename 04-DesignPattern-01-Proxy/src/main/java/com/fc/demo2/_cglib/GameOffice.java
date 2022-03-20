package com.fc.demo2._cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

//打游戏代理
public class GameOffice implements MethodInterceptor {
    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        if (method.getName().equals("login")) {
            System.out.println("请您输入验证码！");
        }

        Object o = proxy.invokeSuper(target, args);

        return o;
    }
}
