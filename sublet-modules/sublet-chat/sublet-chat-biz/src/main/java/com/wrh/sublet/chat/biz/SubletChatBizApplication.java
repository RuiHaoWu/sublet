package com.wrh.sublet.chat.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class SubletChatBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubletChatBizApplication.class, args);
    }

}
