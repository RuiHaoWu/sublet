package com.wrh.sublet.common.log;

import com.wrh.sublet.common.log.aspect.SysLogAspect;
import com.wrh.sublet.common.log.event.SysLogListener;
import com.wrh.sublet.user.api.feign.RemoteLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author wrh
 * @date 2021/11/9
 */
@EnableAsync
@RequiredArgsConstructor
@ConditionalOnWebApplication
@Configuration(proxyBeanMethods = false)
public class LogAutoConfiguration {

    private final RemoteLogService remoteLogService;

    @Bean
    public SysLogAspect sysLogAspect(){
        return new SysLogAspect();
    }

    @Bean
    public SysLogListener sysLogListener(){
        return new SysLogListener(remoteLogService);
    }

}
