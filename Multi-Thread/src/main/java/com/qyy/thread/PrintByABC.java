package com.qyy.thread;

import org.springframework.aop.ThrowsAdvice;

public class PrintByABC {
    private static final Object lock = new Object();
    private static int count =1;
    private static final int Max_COUNT = 90;

    public static void main(String[] args) {
        Thread threadA = new Thread(()->{
            while(count <= Max_COUNT){
                synchronized (lock){
                    if(count % 3 == 1){
                        System.out.println("A");
                        count++;
                        lock.notifyAll();
                    }else{
                        try {
                            lock.wait(); // 如果不是A，等待
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread threadB = new Thread(()->{
            while(count <= Max_COUNT){
                synchronized (lock){
                    if(count % 3 == 2){
                        System.out.println("B");
                        count++;
                        lock.notifyAll();
                    }else{
                        try {
                            lock.wait(); // 如果不是B，等待
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread threadC = new Thread(()->{
            while(count <= Max_COUNT){
                synchronized (lock){
                    if(count % 3 == 0){
                        System.out.println("C");
                        count++;
                        lock.notifyAll();
                    }else{
                        try {
                            lock.wait(); // 如果不是C，等待
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
