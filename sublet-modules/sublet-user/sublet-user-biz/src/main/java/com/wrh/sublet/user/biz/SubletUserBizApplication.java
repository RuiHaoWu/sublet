package com.wrh.sublet.user.biz;

import com.wrh.sublet.common.feign.annotation.EnableSubletFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


/**
 * @author wrh
 * @date 2021/10/12
 */
@EnableSubletFeignClients
@EnableDiscoveryClient
@EnableResourceServer
@SpringBootApplication
public class SubletUserBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubletUserBizApplication.class, args);
    }
}
