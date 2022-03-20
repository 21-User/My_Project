package com.fc.demo2._cglib;

public class GamePlayer implements PlayGame {
    private final String username;

    public GamePlayer(String username) {
        this.username = username;
    }

    @Override
    public void login() {
        System.out.println("欢迎"+username+"登录游戏,时隔多年终于等到您了！");
    }

    @Override
    public void killBoss() {
        System.out.println(username + "成功击杀boss");
    }

    @Override
    public void upgrade() {
        System.out.println("恭喜" + username + "喜提30级");
    }
}
