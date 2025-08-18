package com.qyy.dao.impl;

import com.qyy.dao.Dao1;
import org.springframework.stereotype.Service;

@Service
public class Dao1Impl implements Dao1 {

    @Override
    public void save() {
        System.out.println(System.currentTimeMillis());
        System.out.println("Dao1Impl save");
    }

    // AOP 的用法就在于 无法修改当前业务代码的时候
    // 可以通过动态代理的方法来进行修改
    @Override
    public void update() {
        System.out.println("Dao1Impl update");
    }
}
