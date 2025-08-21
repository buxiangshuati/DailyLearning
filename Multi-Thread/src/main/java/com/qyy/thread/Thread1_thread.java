package com.qyy.thread;

public class Thread1_thread extends Thread {
    // 第一种 继承Thread的线程实现
    @Override
    public void run() {
        System.out.println("Thread1 is running........");
    }

}
