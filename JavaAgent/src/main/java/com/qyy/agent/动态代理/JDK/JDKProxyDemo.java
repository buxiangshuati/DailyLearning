package com.qyy.agent.动态代理.JDK;

import java.lang.reflect.Proxy;

public class JDKProxyDemo {
    public static void main(String[] args) {
        Star realstar = new RealStar("蔡徐坤");

        // 创建代理实例
        /**
         * 使用Proxy.newProxyInstance方法创建代理实例
         * loader 第一个参数是类加载器，通常使用被代理对象的类加载器；
         * interfaces 第二个参数是被代理对象实现的接口列表；
         * invocationHandler 第三个参数是实现了InvocationHandler接口的处理器对象，
         */
        // 动态代理 不需要再重复地去创建代理类 而是重写invoke方法即可
        // 但是基于jdk的动态代理 必须要有接口 即至少实现一个接口
        Star proxy = (Star) Proxy.newProxyInstance(
                realstar.getClass().getClassLoader(),
                realstar.getClass().getInterfaces(),
                new StarAgentHandler(realstar)
        );

        proxy.readLetter("亲爱的哥哥，我特别喜欢唱跳RAP！");

    }

}
