package com.qyy.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = MyProperties.PREFIX)
public class MyProperties {
    public static final String PREFIX = "spring.my.job";

    private boolean enabled;

    private String adminAdress;
}
