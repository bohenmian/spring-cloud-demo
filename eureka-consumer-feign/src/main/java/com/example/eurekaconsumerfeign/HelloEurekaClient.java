package com.example.eurekaconsumerfeign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//name指向服务端名称
@FeignClient(name = "eureka-client")
public interface HelloEurekaClient {

    //服务提供的api
    @GetMapping("/")
    String consumer();
}
