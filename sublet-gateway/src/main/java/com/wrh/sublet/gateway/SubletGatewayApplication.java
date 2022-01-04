package com.wrh.sublet.gateway;

import com.wrh.sublet.common.feign.annotation.EnableSubletFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wrh
 * @date 2021/10/9
 */
@EnableSubletFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SubletGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubletGatewayApplication.class, args);
    }

}
