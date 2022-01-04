package com.wrh.sublet.user.biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wrh.sublet.user.api.entity.RoleAuthorityRel;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色权限关联 mapper 接口
 *
 * @author wrh
 * @date 2021/11/15
 */
@Mapper
public interface RoleAuthorityRelMapper extends BaseMapper<RoleAuthorityRel> {
}
