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

package com.wrh.sublet.user.api.feign;

import com.wrh.sublet.common.core.constants.SecurityConstants;
import com.wrh.sublet.common.core.constants.ServiceNameConstants;
import com.wrh.sublet.common.core.result.R;
import com.wrh.sublet.user.api.entity.SysLog;
import com.wrh.sublet.user.api.feign.factory.RemoteLogServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author wrh
 * @date 2021/10/26
 */
@FeignClient(contextId = "remoteLogService", value = ServiceNameConstants.USER_SERVICE,
        fallbackFactory = RemoteLogServiceFallbackFactory.class)
public interface RemoteLogService {

    /**
     * 保存日志
     *
     * @param sysLog 日志实体
     * @param from 内部标志
     * @return 操作结果
     */
    @PostMapping("/sublet-user/log")
    R<Boolean> saveLog(@RequestBody SysLog sysLog, @RequestHeader(SecurityConstants.FROM) String from);

}
