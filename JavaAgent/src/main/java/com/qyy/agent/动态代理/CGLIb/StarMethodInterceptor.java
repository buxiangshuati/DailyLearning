package com.qyy.agent.动态代理.CGLIb;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class StarMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("经纪人开始工作，准备调用明星的方法：" + method.getName());
        System.out.println("经纪人开始检查信件");

        Object result = proxy.invokeSuper(obj, args); // 调用被代理对象的方法

        System.out.println("经纪人工作结束：");
        System.out.println();
        return result;
    }
}
