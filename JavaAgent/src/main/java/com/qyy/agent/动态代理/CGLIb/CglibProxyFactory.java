package com.qyy.agent.动态代理.CGLIb;


import org.springframework.cglib.proxy.Enhancer;

public class CglibProxyFactory {
    public  static SuperStar getProxy(){
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(SuperStar.class); // 设置要代理的类

        enhancer.setCallback(new StarMethodInterceptor()); // 设置方法拦截器

        return (SuperStar) enhancer.create(); // 创建代理对象
    }
}
