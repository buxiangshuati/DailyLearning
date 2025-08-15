package com.qyy.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(MyProperties.class)
public class MyConfiguration {
    // 该类用于启用 com.qyy.config.MyProperties 配置类
    // 通过 @EnableConfigurationProperties 注解，Spring Boot 会自动加载 com.qyy.config.MyProperties 中的配置
    // 并将其注入到 Spring 容器中，供其他组件使用
    private static final Logger logger = LoggerFactory.getLogger(MyConfiguration.class);

    @Autowired
    private MyProperties myProperties;

    @Bean
    @ConditionalOnMissingBean // 如果容器中没有该类型的 Bean，则创建一个新的 Bean
    @ConditionalOnProperty(prefix = MyProperties.PREFIX,value = "enabled",
            havingValue = "true") // 如果配置文件中 spring.my.job.enabled 为 true，则创建该 Bean
    //
    public MyJobHandler myJobHandler() {
        // 这里仅作演示，意思就可以根据自己的要求来配置
        logger.info("com.qyy.config.MyJobHandler is enabled with properties: {}", myProperties);
        MyJobHandler myJobHandler = new MyJobHandler();
        // myJobHandler.setAdminAddress(myProperties.getAdminAdress());
        // 设置其他属性
        // ...
        return myJobHandler;
    }


}
