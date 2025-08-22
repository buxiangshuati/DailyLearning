package com.qyy.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class HorseRace {
    // 模拟赛马

    // 储存赛马成绩
    private static List<String> results = Collections.synchronizedList(new ArrayList<>());

    // 利用CountDownLatch 控制同时开始
    private static CountDownLatch startLatch = new CountDownLatch(1);

    // 利用CyclicBarrier 保证全部结束了 才公布成绩
    private static CyclicBarrier finishBarrier = new CyclicBarrier(10, new Runnable() {
        @Override
        public void run() {
            System.out.println("所有马匹都到达终点，公布成绩：");
            for (String result : results) {
                System.out.println(result);
            }
        }
    });

    public static void main(String[] args) {
        for(int i=1;i<=10;i++){
            // 创建10匹马匹，每匹马匹在一个独立的线程中运行
            new Thread(new Horse("马匹" + i)).start();
        }

        // 模拟赛马开始，等待一段时间后发出开始信号
        try {
            Thread.sleep(2000); // 等待2秒钟
            System.out.println("赛马开始！");
            startLatch.countDown(); // 发出开始信号
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Horse implements Runnable{

        private String name;// 马匹名称
        public Horse(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            try {
                // 等待开始信号
                // 只有当 CountDownLatch 的计数器为0时，等待的线程将被唤醒
                // 所以此时所有线程都会被阻塞 在外部for循环结束后 进行-1操作
                startLatch.await();

                // 模拟赛马跑步
               long time = (long)(Math.random()*10000);
               Thread.sleep(time);// 模拟马匹跑步时间

                // 到达终点后记录成绩
                results.add(name + " 到达终点，耗时：" + time + " 毫秒");

                // 等待其他马匹到达终点
                finishBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
