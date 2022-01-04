package com.wrh.sublet.auth.service;

import com.wrh.sublet.common.core.constants.CommonConstants;
import com.wrh.sublet.common.core.constants.SecurityConstants;
import com.wrh.sublet.common.core.exception.BizException;
import com.wrh.sublet.common.core.result.R;
import com.wrh.sublet.common.security.service.AuthUser;
import com.wrh.sublet.user.api.dto.UserDTO;
import com.wrh.sublet.user.api.vo.UserInfo;
import com.wrh.sublet.user.api.feign.RemoteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;

/**
 * @author wrh
 * @date 2021/10/28
 */
@Component("userDetailsService")
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final RemoteUserService remoteUserService;

    /**
     * 查询数据库 获取用户信息和权限
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        R<UserInfo> result = remoteUserService.getUserByUsername(username, SecurityConstants.FROM_IN);

        if(result.getCode() != CommonConstants.SUCCESS){
            throw new BizException(result.getMsg());
        }
        UserInfo userInfo = result.getData();
        UserDTO user = userInfo.getUserDto();

        Set<String> authSet = userInfo.getRoles();
        authSet.addAll(userInfo.getPermissions());
        Collection<? extends GrantedAuthority> authorities = AuthorityUtils
                .createAuthorityList(authSet.toArray(new String[0]));

        return new AuthUser(user.getUserId(), username, user.getPassword(),
                user.getLockFlag().equals(CommonConstants.STATUS_NORMAL), true, true, CommonConstants.STATUS_NORMAL.equals(user.getLockFlag()), authorities);
    }
}
