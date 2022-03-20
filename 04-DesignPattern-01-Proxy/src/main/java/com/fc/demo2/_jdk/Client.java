package com.fc.demo2._jdk;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    @Test
    public void test() {
        //真实对象
        GamePlayer gamePlayer = new GamePlayer();

        //游戏工作室【代理对象】
        InvocationHandler gameOffice = new GameOffice(gamePlayer);

        PlayGame proxy =(PlayGame) Proxy.newProxyInstance(gamePlayer.getClass().getClassLoader(),
                gamePlayer.getClass().getInterfaces(), gameOffice);

        proxy.login();
        proxy.killBoss();
        proxy.upgrade();
    }
}
