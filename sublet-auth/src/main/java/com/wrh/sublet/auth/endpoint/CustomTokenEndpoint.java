package com.wrh.sublet.auth.endpoint;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.text.StrPool;
import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import com.wrh.sublet.auth.body.AuthBody;
import com.wrh.sublet.common.core.constants.CacheConstants;
import com.wrh.sublet.common.core.constants.SecurityConstants;
import com.wrh.sublet.common.core.exception.BizException;
import com.wrh.sublet.common.core.result.R;
import com.wrh.sublet.common.redis.service.RedisService;
import com.wrh.sublet.common.security.utils.SecurityUtils;
import com.wrh.sublet.common.web.base.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 自定义获取access_token接口
 *
 * @author wrh
 * @date 2021/11/26
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class CustomTokenEndpoint {

    private final TokenEndpoint tokenEndpoint;

    private final RedisService redisService;

    /**
     * 授权access_token
     */
    @PostMapping
    public R login(@ApiIgnore Principal principal,
                   @RequestBody @Validated(value = {PostMapping.class}) Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {

        // 判断下是不是password模式
        if (Objects.isNull(parameters.get(SecurityConstants.GRANT_TYPE))) {
            // 校验图片验证码
            String verifyCode = Base64.decodeStr(parameters.get(SecurityConstants.VT));
            Object object = redisService.getCacheObject(CacheConstants.VALIDATE_CODE + verifyCode);
            if (Objects.isNull(object) || !object.equals(Base64.decodeStr(parameters.get(SecurityConstants.VC)))) {
                throw new BizException("验证码错误!");
            }
            parameters.put(SecurityConstants.GRANT_TYPE, "password");
            parameters.put("scope", "all");
            parameters.put("username", Base64.decodeStr(parameters.get(SecurityConstants.IA)));
            parameters.put("password", Base64.decodeStr(parameters.get(SecurityConstants.IP)));
        }

        OAuth2AccessToken accessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();

        return R.ok(accessToken);
    }


    /**
     * 退出登录
     */
    @PostMapping("/logout")
    public R logout(@RequestHeader(name = SecurityConstants.AUTHORIZATION) String accessToken) {
        String token = accessToken.replace(SecurityConstants.JWT_TOKEN_PREFIX, StrUtil.EMPTY);
        JWTPayload payload = JWTUtil.parseToken(token).getPayload();
        String jti = payload.getClaim(SecurityConstants.JTI).toString();
        int exp = (int) payload.getClaim(SecurityConstants.EXP);

        long currentTime = System.currentTimeMillis() / 1000;
        if (exp > currentTime) {
            // token未过期，添加至缓存作为黑名单限制访问，缓存时间为token过期剩余时间
            redisService.setCacheObject(SecurityConstants.TOKEN_LOGOUT_PREFIX + jti, null, (exp - currentTime), TimeUnit.SECONDS);
        }

        return R.ok("退出登录成功");
    }

}
