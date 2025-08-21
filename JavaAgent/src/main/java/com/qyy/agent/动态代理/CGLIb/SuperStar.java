package com.qyy.agent.动态代理.CGLIb;

public class SuperStar {
    private String name;

    public SuperStar() {
        this.name = "蔡徐坤";
    }

    public SuperStar(String name) {
        this.name = name;
    }

    public void readLetter(String letter){
        System.out.println(name + "正在读信"+letter);
    }
}
