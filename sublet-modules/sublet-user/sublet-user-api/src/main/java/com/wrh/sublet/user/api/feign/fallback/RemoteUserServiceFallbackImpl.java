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

package com.wrh.sublet.user.api.feign.fallback;


import com.wrh.sublet.common.core.result.R;
import com.wrh.sublet.user.api.vo.UserInfo;
import com.wrh.sublet.user.api.feign.RemoteUserService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author wrh
 * @date 2021/10/28
 */
@Slf4j
@Component
public class RemoteUserServiceFallbackImpl implements RemoteUserService {

    @Setter
    private Throwable cause;

    @Override
    public R<UserInfo> getUserByUsername(String username, String from) {
        log.error("feign 查询用户信息失败:{},{}", username, cause);
        return null;
    }
}
