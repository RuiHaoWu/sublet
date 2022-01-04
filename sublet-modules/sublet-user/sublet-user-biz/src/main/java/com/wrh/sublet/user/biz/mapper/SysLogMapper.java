package com.wrh.sublet.user.biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wrh.sublet.user.api.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * 操作日志 mapper 接口
 *
 * @author wrh
 * @date 2021/11/9
 */
@Mapper
public interface SysLogMapper extends BaseMapper<SysLog> {
}
