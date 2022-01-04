package com.wrh.sublet.user.biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wrh.sublet.user.api.entity.TrackFile;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件记录 mapper 接口
 *
 * @author wrh
 * @date 2021/11/11
 */
@Mapper
public interface TrackFileMapper extends BaseMapper<TrackFile> {
}
