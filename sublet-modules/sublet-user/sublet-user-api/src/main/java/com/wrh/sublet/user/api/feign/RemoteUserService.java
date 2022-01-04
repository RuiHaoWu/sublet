package com.wrh.sublet.user.api.feign;

import com.wrh.sublet.common.core.constants.ServiceNameConstants;
import com.wrh.sublet.common.core.result.R;
import com.wrh.sublet.common.core.constants.SecurityConstants;
import com.wrh.sublet.user.api.vo.UserInfo;
import com.wrh.sublet.user.api.feign.factory.RemoteUserServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author wrh
 * @date 2021/10/28
 */
@FeignClient(value = ServiceNameConstants.USER_SERVICE,fallbackFactory = RemoteUserServiceFallbackFactory.class)
public interface RemoteUserService {


    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @param from 内部标志
     * @return R
     */
    @GetMapping("/sublet-user/user/inner/{username}")
    R<UserInfo> getUserByUsername(@PathVariable(value = "username") String username, @RequestHeader(SecurityConstants.FROM) String from);
}
