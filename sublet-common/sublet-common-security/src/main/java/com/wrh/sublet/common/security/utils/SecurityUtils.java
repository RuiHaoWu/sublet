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

package com.wrh.sublet.common.security.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWTUtil;
import com.wrh.sublet.common.core.constants.SecurityConstants;
import com.wrh.sublet.common.security.service.AuthUser;
import lombok.experimental.UtilityClass;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 安全工具类
 *
 * @author wrh
 * @date 2021/11/3
 */
@UtilityClass
public class SecurityUtils {

    /**
     * 获取Authentication
     */
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取用户
     */
    public AuthUser getUser(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof AuthUser) {
            return (AuthUser) principal;
        }
        return null;
    }

    /**
     * 获取用户
     */
    public AuthUser getUser() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }
        return getUser(authentication);
    }

    /**
     * 获取用户id
     */
    public String getUserId() {
        AuthUser user = getUser();
        return user.getUserId();
    }

    /**
     * 获取用户角色信息
     *
     * @return 角色集合
     */
    public List<String> getRoles() {
        Authentication authentication = getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        List<String> roleIds = new ArrayList<>();
        authorities.stream().filter(granted -> StrUtil.startWith(granted.getAuthority(), "ROLE"))
                .forEach(granted -> {
                    String id = StrUtil.removePrefix(granted.getAuthority(), "ROLE");
                    roleIds.add(id);
                });
        return roleIds;
    }


    /**
     * jwt 解析
     */
    public void checkAuthorization(HttpServletRequest request, String secret) {
        String accessToken = request.getHeader(SecurityConstants.AUTHORIZATION);
        if (StrUtil.isBlank(accessToken)) {
            throw new AccessDeniedException("Token can not be empty");
        }
        String token = accessToken.replace(SecurityConstants.JWT_TOKEN_PREFIX, "");
        boolean verify = JWTUtil.verify(token, secret.getBytes());
        if (!verify) {
            throw new AccessDeniedException("Token parse error");
        }
        long exp = (Integer) JWTUtil.parseToken(token).getPayload().getClaim(SecurityConstants.EXP);

        if (exp < System.currentTimeMillis() / 1000) {
            throw new AccessDeniedException("token is expired");
        }
    }

}
