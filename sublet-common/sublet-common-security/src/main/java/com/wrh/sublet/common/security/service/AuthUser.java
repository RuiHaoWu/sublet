package com.wrh.sublet.common.security.service;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


import java.util.Collection;

/**
 * 拓展用户信息
 *
 * @author wrh
 * @date 2021/10/28
 */
public class AuthUser extends User {

    /**
     * 用户id
     */
    @Getter
    private String userId;

    public AuthUser(String userId, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.userId = userId;
    }
}
