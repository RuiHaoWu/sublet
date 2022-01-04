package com.wrh.sublet.user.api.vo;

import com.wrh.sublet.user.api.dto.UserDTO;
import com.wrh.sublet.user.api.entity.User;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * @author wrh
 * @date 2021/11/15
 */
@Data
public class UserInfo implements Serializable {

    /**
     * user验证信息
     */
    private UserDTO userDto;

    /**
     * 用户基本信息
     */
    private User user;


    /**
     * 角色集合
     */
    private Set<String> roles;


    /**
     * 权限集合
     */
    private Set<String> permissions;


    /**
     * 菜单集合
     */
    private Object menus;
}
