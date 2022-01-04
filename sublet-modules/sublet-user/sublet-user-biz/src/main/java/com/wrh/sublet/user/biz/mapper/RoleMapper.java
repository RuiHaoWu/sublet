package com.wrh.sublet.user.biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wrh.sublet.user.api.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色 mapper 接口
 *
 * @author wrh
 * @date 2021/11/15
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 查询用户绑定的角色列表
     *
     * @param userId userId
     * @return roleList
     */
    List<Role> listRolesByUserId(String userId);
}
