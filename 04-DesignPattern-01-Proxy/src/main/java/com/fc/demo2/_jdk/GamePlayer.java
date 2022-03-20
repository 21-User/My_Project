package com.fc.demo2._jdk;

public class GamePlayer implements PlayGame {
    @Override
    public void login() {
        System.out.println("欢迎21时隔多年登录游戏!");
    }

    @Override
    public void killBoss() {
        System.out.println("成功击杀boss");
    }

    @Override
    public void upgrade() {
        System.out.println("恭喜你喜提30级");
    }
}
