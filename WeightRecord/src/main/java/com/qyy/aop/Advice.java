package com.qyy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Aspect
public class Advice {

    // 定义一个切入点,指定当什么时候执行该aop方法
//    @Pointcut("execution(void com.qyy.service.WeightServiceImpl.addWeight(*, *))")
//    public void pt() {
//    }

    @Around("execution(void com.qyy.service.WeightServiceImpl.addWeight(*, *))")
    public void checkWeight(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        Double weight = (Double) args[0];// 拿到了第一个参数 也就是体重
        ArrayList<Double> weightList = (ArrayList<Double>) args[1];
        double changeRate = Math.abs((weight - weightList.get(weightList.size()-1)) / weightList.get(weightList.size()-1));
        System.out.println("今日体重变化率："+String.format("%.2f", changeRate * 100) + "%");
        if (changeRate < 0.01) {
            System.out.println("⚠️ 今日体重变化不明显，是不是偷懒了？");
        } else if (changeRate > 0.2) {
            System.out.println("🚨 今日体重变化过大，是不是输入错误？");
        } else {
            System.out.println("🟢 体重变化正常，请继续保持哦！");
        }
        pjp.proceed();
    }


}
