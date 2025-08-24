package com.qyy.timetask;

import com.qyy.timetask.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTimer {

    @Autowired
    private TestService testService;

    // 每隔5秒执行一次
    @Scheduled(cron = "0/5 * * * * ?")
    // 这个注解修饰的方法 不能有参数
    public void executeAct() {
        testService.printTest();
    }
}
