package com.qyy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.qyy")
// 启用AOP功能
@EnableAspectJAutoProxy
public class MyConfig {

}
