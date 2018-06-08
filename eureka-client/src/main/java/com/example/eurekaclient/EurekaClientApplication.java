package com.example.eurekaclient;

/**
 * Spring Cloud Eureka的使用,这里是客户端,主要是服务的提供
 * @see org.springframework.cloud.netflix.eureka.EnableEurekaClient 用于服务发现的注解
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
}
