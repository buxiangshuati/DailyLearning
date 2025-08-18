package com.qyy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.qyy")
// 启用AOP功能
@EnableAspectJAutoProxy
public class SpringConfig {

    // 该类是一个配置类,相当于xml配置文件
    // 该类的作用就是扫描com.qyy包下的所有组件
    // 并且启用AOP功能


}
