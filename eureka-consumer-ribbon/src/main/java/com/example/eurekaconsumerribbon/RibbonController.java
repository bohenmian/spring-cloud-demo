package com.example.eurekaconsumerribbon;

/**
 * Ribbon一般用于服务的负载均衡,因为Ribbon用于负载均衡,所以在进行rest调用的时候url就只能有服务的名称,然后ribbon通过负载均衡找到具体的服务实例
 * 如果采用具体的ip+port的url就达不到负载均衡的效果,每次rest都会请求同一个ip
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {

    @Autowired
    private RestTemplate template;

    //不需要使用LoadBalancerClient,因为Ribbon中有一个拦截器会自动的选取服务实例.并将实际请求的IP地址和端口替换这里的服务名
    //可以进RibbonLoadBalancerClient源码打断点确认具体的服务类型
    @GetMapping("consumer")
    public String hello() {
        //接口调用会出现无法发现服务eureka-client,产生这个异常的原因可能是因为Eureka的自我保护模式造成,自我保护模式在单机环境下特别容易出现
        return template.getForObject("http://eureka-client/", String.class);
    }
}
