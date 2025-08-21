package com.qyy.agent.静态代理;

public class StaticProxy {
    public static void main(String[] args) {
        // 创建一个明星
        Star realStar = new RealStar("坤坤");

        // 创建一个代理人
        Star starAgent = new StarAgent(realStar); // 通过实例 来创建一个代理对象

        starAgent.readLetter("坤坤你好，我是你的粉丝，我想见你一面。");
    }
}
