package com.fc.demo1._jdk;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Court {
    @Test
    public void test() {
        //原告(真实对象)
        Lawsuit parties = new Parties();

        //律师事务所(代理对象)
        InvocationHandler lawOffice = new LawOffice(parties);

        //获取代理对象
        Lawsuit proxy =(Lawsuit) Proxy.newProxyInstance(parties.getClass().getClassLoader(),
                parties.getClass().getInterfaces(), lawOffice);

        proxy.submit();

        proxy.defend();

    }


}
