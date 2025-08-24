package com.qyy.timetask.service;

import org.springframework.stereotype.Component;

@Component
public class TestServiceImpl implements TestService {

    @Override
    public void printTest() {
        System.out.println("定时任务执行啦！！！！！！！！");
    }
}
