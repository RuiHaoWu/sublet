package com.wrh.sublet.gateway.filter;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.jwt.JWTUtil;
import com.wrh.sublet.common.core.constants.SecurityConstants;
import com.wrh.sublet.common.core.constants.ServiceNameConstants;
import com.wrh.sublet.common.core.result.R;
import com.wrh.sublet.common.redis.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * 登出拦截
 *
 * @author wrh
 * @date 2021/12/13
 */
@Component
@RequiredArgsConstructor
public class LogoutFilter implements GlobalFilter, Ordered {

    private final RedisService redisService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String path = exchange.getRequest().getURI().getPath();

        // 1. 获取access_token
        String accessToken = exchange.getRequest().getHeaders().getFirst(SecurityConstants.AUTHORIZATION);
        // 2. 如果获取到access_token判断是否是退出登录名单里的
        if (!path.contains(ServiceNameConstants.AUTH_SERVICE) && StrUtil.isNotBlank(accessToken)) {
            // 3 退出登录校验
            String token = accessToken.replace(SecurityConstants.JWT_TOKEN_PREFIX, "");
            String jti = JWTUtil.parseToken(token).getPayload().getClaim(SecurityConstants.JTI).toString();
            if (redisService.hasKey(SecurityConstants.TOKEN_LOGOUT_PREFIX + jti)) {
                ServerHttpResponse response = exchange.getResponse();
                response.getHeaders().set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
                response.getHeaders().set("Access-Control-Allow-Origin", "*");
                response.getHeaders().set("Cache-Control", "no-cache");
                String body = JSONUtil.toJsonStr(R.failed("Access token logged out !"));
                DataBuffer buffer = response.bufferFactory().wrap(body.getBytes(StandardCharsets.UTF_8));
                return response.writeWith(Mono.just(buffer))
                        .doOnError(error -> DataBufferUtils.release(buffer));
            }
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -999;
    }

}
