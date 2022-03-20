package com.fc.demo2._static;

import org.junit.Test;

public class Client {
    @Test
    public void test() {
        //真实对象
        GamePlayer gamePlayer = new GamePlayer();

        //代理对象
        PlayGame proxy = new GamePlayerProxy(gamePlayer);

        proxy.login();
        proxy.killBoss();
        proxy.upgrade();
    }
}
