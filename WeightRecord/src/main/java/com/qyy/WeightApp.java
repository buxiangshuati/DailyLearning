package com.qyy;

import com.qyy.config.MyConfig;
import com.qyy.service.WeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WeightApp {

    public static void main(String[] args) {
        ArrayList<Double> weights = new ArrayList<>();
        weights.addAll(Arrays.asList(70.5, 69.8, 70.0, 68.5, 69.0));

        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
        WeightService weightService = ctx.getBean(WeightService.class);

        System.out.println("您的最近一次体重为："+weights.get(weights.size() - 1));
        // 打印最新的体重
        System.out.print("请输入您的今日体重：");
        Scanner scanner = new Scanner(System.in);
        weightService.addWeight(scanner.nextDouble(), weights);
        System.out.println("您的今日体重为："+ weights.get(weights.size() - 1));
    }


}
