package com.qyy.thread;

public class Thread2_runnable implements Runnable {
    // 第二种 实现Runnable接口的线程实现
    @Override
    public void run() {
        System.out.println("Thread2 is running........");
    }
}
