package com.wrh.sublet.common.security.config;

import com.wrh.sublet.common.security.component.CustomTokenServices;
import com.wrh.sublet.common.security.component.PermitAllUrlProperties;
import com.wrh.sublet.common.security.component.ResourceAccessDeniedHandler;
import com.wrh.sublet.common.security.component.ResourceAuthExceptionEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * 资源服务器配置
 *
 * @author wrh
 * @date 2021/10/27
 */
@Order(90)
@Configuration
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private final ResourceAuthExceptionEntryPoint resourceAuthExceptionEntryPoint;

    private final ResourceAccessDeniedHandler resourceAccessDeniedHandler;

    private final JwtAccessTokenConverter jwtAccessTokenConverter;

    private final PermitAllUrlProperties permitAllUrlProperties;


    /**
     * 配置资源服务器的id
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {

        CustomTokenServices tokenServices = new CustomTokenServices();
        tokenServices.setJwtAccessTokenConverter(jwtAccessTokenConverter);
        tokenServices.setTokenStore(new JwtTokenStore(jwtAccessTokenConverter));

        resources
                .authenticationEntryPoint(resourceAuthExceptionEntryPoint)
                .accessDeniedHandler(resourceAccessDeniedHandler)
                // 替换自定义的tokenService
                .tokenServices(tokenServices);
    }

    /**
     * 有请求，哪些要拦截，哪些要放过，在这里配置
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();

        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry register = http.authorizeRequests();

        register.antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/v2/**").permitAll()
                .antMatchers("/swagger-resources/**").permitAll();

        permitAllUrlProperties.getUrls().forEach(whiteUrl -> {
            register.antMatchers(whiteUrl.getMethod(),whiteUrl.getUrl()).permitAll();
        });

    }

}
