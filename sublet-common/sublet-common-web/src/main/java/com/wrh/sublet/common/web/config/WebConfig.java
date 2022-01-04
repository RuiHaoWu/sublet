package com.wrh.sublet.common.web.config;

import com.wrh.sublet.common.web.utils.BufferedRequestWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.AbstractRequestLoggingFilter;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * web配置类
 *
 * @author wrh
 * @date 2021/11/18
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 缓存请求
     */
    @Bean
    public AbstractRequestLoggingFilter commonsRequestLoggingFilter() {
        return new CommonsRequestLoggingFilter() {
            @Override
            protected boolean shouldLog(HttpServletRequest request) {
                return logger.isInfoEnabled();
            }

            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
                BufferedRequestWrapper bufferedRequestWrapper = new BufferedRequestWrapper(request);
                super.doFilterInternal(bufferedRequestWrapper, response, filterChain);
            }
        };
    }
}
