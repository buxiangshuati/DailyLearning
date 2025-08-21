package com.qyy.agent.静态代理;

public class StarAgent implements Star{
    private Star star;

    public StarAgent(Star star) {
        this.star = star;
    }

    @Override
    public void readLetter(String letter) {
        // 所谓的代理 也就是在原来的业务逻辑上 加入额外的处理
        // 就像下面一样 在readLetter方法中加入了额外的处理逻辑
        System.out.println("代理人正在处理信件...");
        System.out.println("代理人把信件交给明星处理。");
        star.readLetter(letter);
        System.out.println("代理人已处理完毕。");
    }
}
