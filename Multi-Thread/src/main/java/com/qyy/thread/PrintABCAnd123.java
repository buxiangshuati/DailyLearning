package com.qyy.thread;

public class PrintABCAnd123 {
    private static final Object lock = new Object();
    private static boolean printNumber = true; // 标志位，true表示打印数字，false表示打印字母

    public static void main(String[] args) {
        Thread threadNumber = new Thread(new NumberPrint());
        Thread threadABC = new Thread(new ABCPrint());

        threadNumber.start();
        threadABC.start();

    }

    static class NumberPrint implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                try {
                    for (int i = 1; i <= 3; i++) {
                        // 当printNumber为false时，即不打印数字时，等待另一个线程
                        while (!printNumber) {
                            lock.wait();
                        }
                        System.out.println("当前打印数字：" + i);
                        printNumber = false; // 切换标志位，下一次打印字母
                        lock.notify(); // 唤醒另一个线程
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ABCPrint implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                try {
                    for (char i = 'A'; i <= 'C'; i++) {
                        // 当printNumber为false时，即不打印数字时，等待另一个线程
                        while (printNumber) {
                            lock.wait();
                        }
                        System.out.println("当前打印字母：" + i);
                        printNumber = true; // 切换标志位，下一次打印数字
                        lock.notify(); // 唤醒另一个线程
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
