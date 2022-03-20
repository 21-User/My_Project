package com.fc.demo2._static;

//打游戏代理
public class GamePlayerProxy implements PlayGame{
    //代理中包含真实对象
    private final GamePlayer gamePlayer;

    public GamePlayerProxy(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    @Override
    public void login() {
        //代理登录账号需要验证
        this.verify();
        gamePlayer.login();
    }

    @Override
    public void killBoss() {
        gamePlayer.killBoss();
        this.addMoney();
    }

    @Override
    public void upgrade() {
        gamePlayer.upgrade();
        this.logout();
    }

    private void verify() {
        System.out.println("请输入您的验证码！！");
    }

    private void addMoney() {
        System.out.println("成功击杀boss，获得全队金币加成");
    }

    private void logout() {
        System.out.println("期待你的下次登录！！");
    }

}
