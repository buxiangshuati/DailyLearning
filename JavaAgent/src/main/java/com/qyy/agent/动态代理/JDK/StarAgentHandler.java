package com.qyy.agent.动态代理.JDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarAgentHandler implements InvocationHandler {
    private Object target; // 被代理的真实对象

    public StarAgentHandler(Object target){
        this.target = target;
    }

    // 然后需要实现invoke方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在这里可以添加代理逻辑，比如打印日志、权限检查等
        System.out.println("明星经纪人：准备工作");
        System.out.println("明星经纪人：开始处理信件");
        // 调用真实对象的方法
        Object result = method.invoke(target, args);

        System.out.println("明星经纪人：善后工作 信件处理完成");
        return result;
    }


}
