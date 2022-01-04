package com.wrh.sublet.user.biz.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wrh.sublet.user.api.body.UserBody;
import com.wrh.sublet.user.api.vo.UserInfo;
import com.wrh.sublet.user.api.entity.User;


/**
 * @author wrh
 * @date 2021/10/12
 */
public interface UserService extends IService<User> {

    /**
     * 认证服务器获取用户信息
     *
     * @param username 用户名
     * @return userInfo
     */
    UserInfo getUserByUsername(String username);

    /**
     * 根据用户名获取用户信息
     *
     * @param username 用户名
     * @return userInfo
     */
    UserInfo getUserInfo(String username);


    /**
     * 通过id获取用户信息
     *
     * @param userId 用户id
     * @return User
     */
    User selectById(String userId);


    /**
     * 新增用户
     * @param userBody 用户信息
     * @return user
     */
    User save(UserBody userBody);

    /**
     * 虚拟删除用户
     * @param id userId
     * @return 操作结果
     */
    Boolean delete(String id);

    /**
     * 编辑用户信息
     * @param id userId
     * @param userBody 用户信息
     * @return user
     */
    User editUserInfo(String id, UserBody userBody);

    /**
     * 修改用户锁定状态
     * @param id userId
     * @return 操作结果
     */
    Boolean editLockStatus(String id);

    /**
     * 发送邮件
     * @param email 邮箱
     * @return 操作结果
     */
    void sendMail(String email);

    /**
     * 获取用户列表
     * @param page 分页参数
     * @param userBody 查询参数
     * @return 用户列表
     */
    Object getUserPage(Page page, UserBody userBody);

    /**
     * 修改密码
     *
     * @param userId userId
     * @param userBody body
     * @return 操作结果
     */
    Boolean modifyPwd(String userId, UserBody userBody);
}
