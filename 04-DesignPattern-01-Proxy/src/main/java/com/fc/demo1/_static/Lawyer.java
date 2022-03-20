package com.fc.demo1._static;

//律师类，代理的对象
public class Lawyer implements Lawsuit {
    //代理类中包含一个被代理的对象
    private final Lawsuit parties;

    //通过构造方法进行赋值
    public Lawyer(Lawsuit parties) {
        this.parties = parties;
    }

    @Override
    public void submit() {
        //原告找律师（代理）收集证据
        this.gatherEvidence();
        //原告提起诉讼
        parties.submit();
    }

    @Override
    //辩护
    public void defend() {
        parties.defend();
        this.exchangeOpinions();
    }

    // 收集证据
    private void gatherEvidence() {
        System.out.println("收集证据");
    }

    // 交换意见
    private void exchangeOpinions() {
        System.out.println("交换意见");
    }
}
