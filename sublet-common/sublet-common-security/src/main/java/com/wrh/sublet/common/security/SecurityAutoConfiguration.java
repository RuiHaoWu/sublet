package com.wrh.sublet.common.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wrh.sublet.common.security.component.PermitAllUrlProperties;
import com.wrh.sublet.common.security.component.ResourceAccessDeniedHandler;
import com.wrh.sublet.common.security.component.ResourceAuthExceptionEntryPoint;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wrh
 */
@Configuration
@EnableConfigurationProperties(PermitAllUrlProperties.class)
public class SecurityAutoConfiguration {

    @Bean
    public ResourceAuthExceptionEntryPoint resourceAuthExceptionEntryPoint(ObjectMapper objectMapper) {
        return new ResourceAuthExceptionEntryPoint(objectMapper);
    }

    @Bean
    public ResourceAccessDeniedHandler resourceAccessDeniedHandler(ObjectMapper objectMapper){
        return new ResourceAccessDeniedHandler(objectMapper);
    }

    @Bean
    public PermitAllUrlProperties permitAllUrlProperties(){
        return new PermitAllUrlProperties();
    }
}
