package com.fc.demo2._cglib;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    @Test
    public void test() {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(GamePlayer.class);
        enhancer.setCallback(new GameOffice());
        GamePlayer proxy = (GamePlayer) enhancer.create(new Class[]{String.class},new Object[]{"21"});

        proxy.login();
        proxy.killBoss();
        proxy.upgrade();
    }
}
