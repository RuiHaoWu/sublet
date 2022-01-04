package com.wrh.sublet.user.biz.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wrh.sublet.user.api.body.SysLogBody;
import com.wrh.sublet.user.api.entity.SysLog;
import com.wrh.sublet.user.biz.mapper.SysLogMapper;
import com.wrh.sublet.user.biz.service.SysLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 操作日志记录实现类
 *
 * @author wrh
 * @date 2021/11/9
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {

    @Override
    @SuppressWarnings("unchecked")
    public Object getLogPage(Page page, SysLogBody sysLogBody) {

        LambdaQueryWrapper<SysLog> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Objects.nonNull(sysLogBody.getType()), SysLog::getType, sysLogBody.getType());
        wrapper.like(!StrUtil.isBlank(sysLogBody.getUsername()),SysLog::getCreateBy, sysLogBody.getUsername());
        wrapper.orderByDesc(SysLog::getCreateTime);

        if (ArrayUtils.isNotEmpty(sysLogBody.getRangeTime())) {
            wrapper.ge(SysLog::getCreateTime, sysLogBody.getRangeTime()[0]).le(SysLog::getCreateTime, sysLogBody.getRangeTime()[1]);
        }
        return baseMapper.selectPage(page, wrapper);
    }

    @Override
    public Boolean deleteByIds(List<Integer> ids) {
        baseMapper.deleteBatchIds(ids);
        return Boolean.TRUE;
    }
}
