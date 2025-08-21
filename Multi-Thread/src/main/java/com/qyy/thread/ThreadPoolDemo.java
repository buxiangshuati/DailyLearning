package com.qyy.thread;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
//-------------------------------------------------------------------------------------------------------------
        // 下面使用线程池Executor来创建线程
        // 创建一个固定大小的线程池，线程池中有3个线程
        ExecutorService pool = Executors.newFixedThreadPool(3);
        // 提交5个任务到线程池中
        for(int i=1;i<=100;i++){
            final int taskId = i;
            pool.submit(() -> {
                System.out.println("Task " + taskId + " is running in thread: " + Thread.currentThread().getName());
            });
        }
        pool.shutdown(); // 关闭线程池
//-------------------------------------------------------------------------------------------------------------
        // 使用ThreadPoolExecutor 可以更灵活地创建线程池
        ExecutorService Threadpool = new ThreadPoolExecutor(
                3, // 核心线程数
                10, // 最大线程数
                60L, // 空闲线程存活时间
                TimeUnit.SECONDS, // 时间单位
                new ArrayBlockingQueue<>(10), // 阻塞队列，存放等待执行的任务
                Executors.defaultThreadFactory(), // 线程工厂，用于创建新线程
                new ThreadPoolExecutor.AbortPolicy() // 拒绝策略，当线程池满时，抛出异常
        );

        for(int i=1;i<=10;i++){
            final int taskId = i;
            Threadpool.submit(() -> {
                System.out.println("Task " + taskId + " is running in thread: " + Thread.currentThread().getName());
            });
        }
        Threadpool.shutdown(); // 关闭线程池
    }
}
