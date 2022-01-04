package com.wrh.sublet.common.feign.cofig;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wrh
 * @date 2021/10/28
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLog(){
        return Logger.Level.FULL;
    }
}
