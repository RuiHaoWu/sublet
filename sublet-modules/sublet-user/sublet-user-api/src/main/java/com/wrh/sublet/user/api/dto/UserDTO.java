package com.wrh.sublet.user.api.dto;

import lombok.Data;

/**
 * @author wrh
 * @date 2021/12/14
 */
@Data
public class UserDTO {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态
     */
    private Integer lockFlag;
}
