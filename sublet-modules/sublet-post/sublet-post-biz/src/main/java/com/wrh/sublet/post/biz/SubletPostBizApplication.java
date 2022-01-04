package com.wrh.sublet.post.biz;

import com.wrh.sublet.common.feign.annotation.EnableSubletFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author wrh
 * @date 2021/10/20
 */
@EnableSubletFeignClients  // 一个服务想要调用其他服务 必须加该注解
@EnableDiscoveryClient
@EnableResourceServer
@SpringBootApplication
public class SubletPostBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubletPostBizApplication.class, args);
    }

}
