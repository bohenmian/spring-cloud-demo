package com.example.eurekaconsumerribbonhystrix.service.impl;

/**
 * @see com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand 可以用来指定服务的降级策略和超时时间
 */

import com.example.eurekaconsumerribbonhystrix.service.ConsumerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    private RestTemplate template;

    @Override
    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer() {
        return template.getForObject("http://eureka-client/", String.class);
    }

    public String fallback() {
        return "fallback";
    }

}