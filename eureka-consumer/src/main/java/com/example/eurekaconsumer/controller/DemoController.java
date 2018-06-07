package com.example.eurekaconsumer.controller;

/**
 * Spring Cloud Consumer的使用,消费eureka-client的服务
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate template;

    @GetMapping("consumer")
    public String serviceChoose() {
        //通过负载均衡选择一个eureka-client的服务实例,这里的参数应该是服务的名称
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");

        //拼接访问接口的路径
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/";
        System.out.println(url);
        return template.getForObject(url, String.class);
    }
}
