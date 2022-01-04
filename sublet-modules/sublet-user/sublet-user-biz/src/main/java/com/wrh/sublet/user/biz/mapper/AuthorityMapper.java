package com.wrh.sublet.user.biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wrh.sublet.user.api.entity.Authority;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 权限 mapper 接口
 *
 * @author wrh
 * @date 2021/11/15
 */
@Mapper
public interface AuthorityMapper extends BaseMapper<Authority> {

    /**
     * 获取角色绑定的权限列表
     *
     * @param roleIds 角色id列
     * @return authList
     */
    List<Authority> listAuthoritiesByRoleId(String roleIds);
}
