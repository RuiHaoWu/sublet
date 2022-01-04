package com.wrh.sublet.common.feign;

import com.wrh.sublet.common.feign.cofig.FeignConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author DM
 */
@Configuration
public class FeignAutoConfiguration {

    @Bean
    public FeignConfig feignConfig(){
        return new FeignConfig();
    }
}
