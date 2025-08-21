package com.qyy.agent.动态代理.CGLIb;

public class CglinDemo {
    public static void main(String[] args) {
        // 获取了一个代理对象
        SuperStar proxy = CglibProxyFactory.getProxy();

        proxy.readLetter("哥哥 你知道什么是 露出鸡脚 和 香精煎鱼吗");
        proxy.readLetter("哥哥 你知道什么是 你干嘛吗");

    }
}
