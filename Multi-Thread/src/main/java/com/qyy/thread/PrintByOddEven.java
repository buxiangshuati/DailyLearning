package com.qyy.thread;

public class PrintByOddEven {
    private static final Object lock = new Object();
    private static int count = 1;
    private static final int Max_COUNT = 100;

    public static void main(String[] args) {
        Thread threadOdd = new Thread(() ->{
            while(count <= Max_COUNT){
                synchronized (lock){
                    if(count % 2 != 0){
                        System.out.println("现在是奇数：" +count);
                        count++;
                        lock.notify();
                    }else{
                        try {
                            lock.wait(); // 如果是偶数，等待
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread threadEven = new Thread(() ->{
            while(count <= Max_COUNT){
                synchronized (lock){
                    if(count % 2 == 0){
                        System.out.println("现在是偶数：" +count);
                        count++;
                        lock.notify();
                    }else{
                        try {
                            lock.wait(); // 如果是偶数，等待
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        threadOdd.start();
        threadEven.start();
    }
}
