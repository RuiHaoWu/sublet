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

package com.wrh.sublet.user.api.feign.factory;


import com.wrh.sublet.user.api.feign.RemoteLogService;
import com.wrh.sublet.user.api.feign.fallback.RemoteLogServiceFallbackImpl;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author lengleng
 * @date 2019/2/1
 */
@Component
public class RemoteLogServiceFallbackFactory implements FallbackFactory<RemoteLogService> {

    @Override
    public RemoteLogService create(Throwable throwable) {
        RemoteLogServiceFallbackImpl remoteLogServiceFallback = new RemoteLogServiceFallbackImpl();
        remoteLogServiceFallback.setCause(throwable);
        return remoteLogServiceFallback;
    }

}
