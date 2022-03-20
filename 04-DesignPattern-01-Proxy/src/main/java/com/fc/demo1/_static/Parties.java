package com.fc.demo1._static;

public class Parties implements Lawsuit {
    @Override
    //诉讼
    public void submit() {
        System.out.println("老板卷钱跑路了！！");
    }

    @Override
    //辩护
    public void defend() {
        System.out.println("欠债还钱，天经地义");
    }
}
