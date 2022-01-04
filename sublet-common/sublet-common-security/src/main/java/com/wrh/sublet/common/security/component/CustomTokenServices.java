package com.wrh.sublet.common.security.component;


import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Map;

/**
 * 自定义客户端TokenService
 * remoteTokenService 去认证服务器校验token，现在jwt实现自己校验token并转化User信息
 *
 * @author wrh
 * @date 2021/11/3
 */
@Slf4j
public class CustomTokenServices implements ResourceServerTokenServices {

    @Setter
    private TokenStore tokenStore;

    @Setter
    private JwtAccessTokenConverter jwtAccessTokenConverter;


    /**
     * 用于从指定的令牌字符串中抽取认证信息, 构建 OAuth2Authentication 对象.
     */
    @Override
    public OAuth2Authentication loadAuthentication(String accessTokenValue) throws AuthenticationException, InvalidTokenException {
        OAuth2AccessToken accessToken = tokenStore.readAccessToken(accessTokenValue);
        if (accessToken == null) {
            throw new InvalidTokenException("Invalid access token: " + accessTokenValue);
        } else if (accessToken.isExpired()) {
            throw new InvalidTokenException("Access token expired");
        }

        OAuth2Authentication oAuth2Authentication = tokenStore.readAuthentication(accessToken);
        DefaultAccessTokenConverter defaultAccessTokenConverter = new DefaultAccessTokenConverter();
        // 指定将抽取信息为转换成自定义的AuthUser
        UserAuthenticationConverter userTokenConverter = new AuthUserAuthenticationConverter();
        defaultAccessTokenConverter.setUserTokenConverter(userTokenConverter);
        Map<String, ?> map = jwtAccessTokenConverter.convertAccessToken(accessToken, oAuth2Authentication);
        return defaultAccessTokenConverter.extractAuthentication(map);
    }


    @Override
    public OAuth2AccessToken readAccessToken(String accessToken) {
        return tokenStore.readAccessToken(accessToken);
    }
}
