package com.qyy.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ThreadDemo {

    public static void main(String[] args) throws Exception{
        Thread1_thread thread1 = new Thread1_thread();
        thread1.start(); // 启动线程1
        // 由于单继承 这个类就不能继承其他的类了
//---------------------------------------------------------------------------------------

        Thread thread2 = new Thread(new Thread2_runnable());// 启动线程2，直接创建并启动
        thread2.start();
//---------------------------------------------------------------------------------------
        // callable 支持抛异常 支持返回值
        Callable<String> callable = new Thread3_callable();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread thread3 = new Thread(futureTask);
        thread3.start(); // 启动线程3

        String res = futureTask.get();// 获取线程3的返回值
        System.out.println(res);
//---------------------------------------------------------------------------------------
    }


}
