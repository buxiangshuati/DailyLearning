package com.qyy.agent.动态代理.JDK;

public class RealStar implements Star {
    private String name;

    public RealStar(String name) {
        this.name = name;
    }

    @Override
    public void readLetter(String letter) {
        // 真正的明星本人 只需要实现自己的业务逻辑 在这里就是读信
        System.out.println(name+ "专注于读取信件，内容是："+letter);
    }
}
