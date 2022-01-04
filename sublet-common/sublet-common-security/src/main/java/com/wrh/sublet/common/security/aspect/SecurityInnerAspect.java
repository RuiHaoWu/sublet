/*
 * Copyright (c) 2020 pig4cloud Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wrh.sublet.common.security.aspect;

import cn.hutool.core.util.StrUtil;
import com.wrh.sublet.common.security.annotation.Inner;
import com.wrh.sublet.common.core.constants.SecurityConstants;
import com.wrh.sublet.common.security.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.servlet.http.HttpServletRequest;

/**
 * 对放行内部调用接口做一下权限补充
 *
 * @author wrh
 * @date 2021/10/8
 */
@Slf4j
@Aspect
@RequiredArgsConstructor
public class SecurityInnerAspect implements Ordered {

    private final HttpServletRequest request;

    private final JwtAccessTokenConverter jwtAccessTokenConverter;


    @SneakyThrows
    @Around("@within(inner) || @annotation(inner)")
    public Object around(ProceedingJoinPoint point, Inner inner) {
        // 实际注入的inner实体由表达式后一个注解决定，即是方法上的@Inner注解实体，若方法上无@Inner注解，则获取类上的
        if (inner == null) {
            Class<?> clazz = point.getTarget().getClass();
            inner = AnnotationUtils.findAnnotation(clazz, Inner.class);
        }

        String header = request.getHeader(SecurityConstants.FROM);
        if (inner.value()) {
//            if (StrUtil.isBlank(header)) {
//                // 获取jwtSecret
//                String jwtSecret = jwtAccessTokenConverter.getKey().get("value");
//                // token校验
//                SecurityUtils.checkAuthorization(request, jwtSecret);
//            } else {
                if (!StrUtil.equals(header, SecurityConstants.FROM_IN)) {
                    log.warn("内部访问接口 {} 没有权限", point.getSignature().getName());
                    throw new AccessDeniedException("Access is denied");
//                }
            }
        }
        return point.proceed();
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 1;
    }

}
