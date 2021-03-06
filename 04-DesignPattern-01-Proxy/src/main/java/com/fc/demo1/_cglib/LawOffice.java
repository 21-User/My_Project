package com.fc.demo1._cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import netscape.security.Target;

import java.lang.reflect.Method;

public class LawOffice implements MethodInterceptor {

    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        if (method.getName().equals("submit")) {
            System.out.println("收集证据");
        }

        Object o = proxy.invokeSuper(target, args);

        if (method.getName().equals("defend")) {
            System.out.println("交换意见");
        }
        return o;
    }
}
