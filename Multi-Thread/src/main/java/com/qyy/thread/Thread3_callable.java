package com.qyy.thread;

import java.util.concurrent.Callable;

public class Thread3_callable implements Callable<String> {
    // 第三种 实现Callable接口的线程实现
    // 需要返回值
    @Override
    public String call() throws Exception {
        System.out.println("Thread3 is running........");
        return "Thread3 result";
    }
}
