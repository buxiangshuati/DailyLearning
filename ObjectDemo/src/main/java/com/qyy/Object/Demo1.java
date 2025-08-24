package com.qyy.Object;


import org.openjdk.jol.info.ClassLayout;

public class Demo1 {
    public static void main(String[] args) {
        LockObject lockObject = new LockObject();
        // 查看对象的内存布局
        System.out.println(ClassLayout.parseInstance(lockObject).toPrintable());
    }

    static class LockObject{
        int age;
        String name;
    }
}
