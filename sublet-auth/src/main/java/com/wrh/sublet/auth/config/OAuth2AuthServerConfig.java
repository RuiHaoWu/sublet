package com.wrh.sublet.auth.config;

import com.wrh.sublet.common.security.service.AuthUser;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.sql.DataSource;
import java.util.*;

/**
 * 认证服务器配置
 *
 * @author wrh
 * @date 2021/10/27
 */
@Configuration
@RequiredArgsConstructor
@EnableAuthorizationServer
public class OAuth2AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    private final AuthenticationManager authenticationManager;

    private final DataSource dataSource;

    /**
     * 配置资源服务器过来验token 的规则
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {

        // Spring Security OAuth2会公开了两个端点，用于检查令牌（/oauth/check_token和/oauth/token_key），这些端点默认受保护denyAll()。
        // isAuthenticated()代表client_id和secret验证 permitAll()则代表不需要验证
        security
                //  开启/oauth/check_token验证端口认证权限访问 校验token jwt的可以关闭这个
                .checkTokenAccess("isAuthenticated()")
                //  开启/oauth/token_key验证端口认证权限访问  资源服务器获取jwt的签名
                .tokenKeyAccess("isAuthenticated()")
                // client_id和secret可以通过表单提交 默认false只能通过Basic Auth
                .allowFormAuthenticationForClients();
    }


    /**
     * 配置客户端应用的信息，让认证服务器知道有哪些客户端应用来申请令牌。
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 去oauth_client_details 表里读取客户端信息
        clients.jdbc(dataSource);
    }

    /**
     * 配置用户信息
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {

        // access_token jwt增强配置
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> enhancers = new ArrayList<>();
        enhancers.add(tokenEnhancer());
        enhancers.add(jwtAccessTokenConverter());
        enhancerChain.setTokenEnhancers(enhancers);


        endpoints
                //告诉服务器要用自定义的tokenStore里去存取token
                .tokenStore(tokenStore())
                // 这里指定userDetailService是专门给refresh_token使用的,正常四种模式用不到
                .userDetailsService(userDetailsService)
                // 每次刷新token的refreshToken是否改变 默认为true
                .reuseRefreshTokens(true)
                // token增强配置
                .tokenEnhancer(enhancerChain)
                // 密码模式必须配置这个
                .authenticationManager(authenticationManager)
                // 修改获取access_token地址
                .allowedTokenEndpointRequestMethods(HttpMethod.POST).pathMapping("/oauth/token", "/auth");

    }

    /**
     * token存取配置, 默认是内存
     * 有jdbc,redis,jwt可选
     */
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    /**
     * 设置jwt签名
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("sublet-wrh");
        return converter;
    }

    /**
     * 扩展jwt 增加user_id字段
     */
    @Bean
    public TokenEnhancer tokenEnhancer() {
        return (accessToken, authentication) -> {
            final Map<String, Object> additionalInfo = new HashMap<>(2);
            AuthUser authUser = (AuthUser) authentication.getUserAuthentication().getPrincipal();
            additionalInfo.put("user_id", authUser.getUserId());

            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
            return accessToken;
        };
    }
}
