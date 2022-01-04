package com.wrh.sublet.gateway.handler;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.util.IdUtil;
import com.wrh.sublet.common.core.constants.CacheConstants;
import com.wrh.sublet.common.core.result.R;
import com.wrh.sublet.common.redis.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * 图片验证码处理类
 *
 * @author wrh
 * @date 2021/11/25
 */
@Component
@RequiredArgsConstructor
public class ValidateCodeHandler implements HandlerFunction<ServerResponse> {

    private final RedisService redisService;

    @Override
    public Mono<ServerResponse> handle(ServerRequest serverRequest) {


        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(137, 40, 4, 80);
        lineCaptcha.createCode(); //生成code

        // 缓存验证码至redis
        String uuid = IdUtil.simpleUUID();
        redisService.setCacheObject(CacheConstants.VALIDATE_CODE + uuid, lineCaptcha.getCode(), 300L, TimeUnit.SECONDS);

        Map<String, String> resultMap = new HashMap<>(4);
        resultMap.put("uuid", uuid);
        resultMap.put("img", lineCaptcha.getImageBase64Data());


        return ServerResponse.status(HttpStatus.OK).body(BodyInserters.fromValue(R.ok(resultMap)));
    }
}
