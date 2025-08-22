package com.qyy.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintOddEvenByReentrantLock {
    private static final Lock lock = new ReentrantLock();
    private static final Condition oddCondition = lock.newCondition();
    private static final Condition evenCondition = lock.newCondition();
    private static int count = 1;
    private static final int MAX_COUNT = 100;

    public static void main(String[] args) {
        Thread threadOdd = new Thread(new OddThread());
        Thread threadEven = new Thread(new EvenThread());

        threadOdd.start();
        threadEven.start();
    }

    static class OddThread implements Runnable {
        @Override
        public void run() {
            while (count <= MAX_COUNT) {
                // 加锁
                lock.lock();
                try {
                    if (count % 2 != 0) {
                        System.out.println("现在是奇数：" + count);
                        count++;
                        evenCondition.signal(); // 唤醒偶数线程
                    } else {
                        oddCondition.await(); // 等待奇数条件
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
    static class EvenThread implements Runnable {
        @Override
        public void run() {
            while (count <= MAX_COUNT) {
                // 加锁
                lock.lock();
                try {
                    if (count % 2 == 0) {
                        System.out.println("现在是偶数：" + count);
                        count++;
                        oddCondition.signal(); // 唤醒奇数线程
                    } else {
                        evenCondition.await(); // 等待偶数条件
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
