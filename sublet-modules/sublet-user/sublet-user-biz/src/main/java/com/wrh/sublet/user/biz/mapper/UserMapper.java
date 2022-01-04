package com.wrh.sublet.user.biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wrh.sublet.user.api.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表 mapper 接口
 *
 * @author wrh
 * @date 2021/10/12
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 通过邮箱查找用户
     *
     * @param email 邮箱
     * @return user
     */
    User findUserByEmail(String email);

    /**
     * 通过用户名查找用户
     *
     * @param username 用户名
     * @return user
     */
    User findUserByUsername(String username);
}
