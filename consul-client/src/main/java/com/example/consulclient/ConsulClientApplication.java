package com.example.consulclient;

/**
 * Consul可以作为服务的发现者,它提供了服务端,但是一定要下载Consul的服务端程序并且运行(consul agent -dev)
 * Consul的UI界面(localhost:8050)
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulClientApplication.class, args);
    }
}
