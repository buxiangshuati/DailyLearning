package com.qyy.thread;

import java.util.concurrent.Semaphore;

public class PrintOddEvenBySem {
    // 使用信号量来控制奇数和偶数的打印顺序
    // 因为我们需要交替打印 所以需要总的信号量就是1
    // 奇数先打 所以初始时奇数信号量为1 偶数信号量为0
    private static final Semaphore oddSemaphore = new Semaphore(1);
    private static final Semaphore evenSemaphore = new Semaphore(0);
    // 信号量相当于就是许可证 没有的那个线程 会被阻塞

    private static int count = 1;
    private static final int MAX_COUNT = 100;

    public static void main(String[] args) {
        Thread threadOdd = new Thread(new OddThread());
        Thread threadEven = new Thread(new EvenThread());

        // 所以启动顺序无所谓
        threadEven.start();
        threadOdd.start();

    }
    static class OddThread implements Runnable {
        @Override
        public void run() {
            while (count <= MAX_COUNT) {
                try {
                    oddSemaphore.acquire(); // 获取奇数信号量
                    if (count % 2 != 0) {
                        System.out.println("现在是奇数：" + count);
                        count++;
                        evenSemaphore.release(); // 唤醒偶数线程
                    } else {
                        // 如果不是奇数，释放奇数信号量并等待偶数条件
                        oddSemaphore.release(); // 等待奇数条件
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class EvenThread implements Runnable {
        @Override
        public void run() {
            while (count <= MAX_COUNT) {
                try {
                    evenSemaphore.acquire(); // 尝试获取偶数信号量
                    if (count % 2 == 0) {
                        System.out.println("现在是偶数：" + count);
                        count++;
                        oddSemaphore.release(); // 唤醒奇数线程
                    } else {
                        // 如果不是偶数，释放偶数信号量并等待奇数条件
                        evenSemaphore.release(); // 等待偶数条件
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
