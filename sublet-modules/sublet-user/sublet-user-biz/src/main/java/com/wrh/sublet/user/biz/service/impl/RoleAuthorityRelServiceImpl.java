package com.wrh.sublet.user.biz.service.impl;

import cn.hutool.core.text.StrPool;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wrh.sublet.user.api.entity.Authority;
import com.wrh.sublet.user.api.entity.RoleAuthorityRel;
import com.wrh.sublet.user.biz.mapper.AuthorityMapper;
import com.wrh.sublet.user.biz.mapper.RoleAuthorityRelMapper;
import com.wrh.sublet.user.biz.service.RoleAuthorityRelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色权限关联服务实现类
 *
 * @author wrh
 * @date 2021/11/16
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RoleAuthorityRelServiceImpl extends ServiceImpl<RoleAuthorityRelMapper, RoleAuthorityRel> implements RoleAuthorityRelService {

    private final RoleAuthorityRelMapper roleAuthorityRelMapper;
    private final AuthorityMapper authorityMapper;

    @Override
    public void setRoleAuthority(Integer roleId, Integer[] authorityIds) {
        List<RoleAuthorityRel> collect = Arrays.stream(authorityIds).map(authId -> {
            RoleAuthorityRel roleAuth = new RoleAuthorityRel();
            roleAuth.setAuthId(authId);
            roleAuth.setRoleId(roleId);
            return roleAuth;
        }).collect(Collectors.toList());
        this.saveBatch(collect);
    }

    @Override
    public void delRoleAuthority(Integer roleId) {
        roleAuthorityRelMapper.delete(Wrappers.<RoleAuthorityRel>update().lambda().eq(RoleAuthorityRel::getRoleId, roleId));
    }


    @Override
    public List<Authority> getAuthorityListByRoleId(Integer roleId) {

        List<Integer> authorities = roleAuthorityRelMapper.selectList(Wrappers.<RoleAuthorityRel>query().lambda().eq(RoleAuthorityRel::getRoleId, roleId)).stream()
                .map(RoleAuthorityRel::getAuthId)
                .collect(Collectors.toList());

        return authorities.size() == 0 ? null : authorityMapper.selectList(Wrappers.<Authority>query().lambda().in(Authority::getAuthId, authorities));
    }
}
