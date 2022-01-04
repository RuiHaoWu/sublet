package com.wrh.sublet.post.biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wrh.sublet.post.api.body.SubletInfoBody;
import com.wrh.sublet.post.api.entity.SubletInfo;
import com.wrh.sublet.post.api.vo.SubletInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wrh
 * @date 2021/10/20
 */
@Mapper
public interface SubletInfoMapper extends BaseMapper<SubletInfo> {

    /**
     * 分页查询(含label）
     * 前台用户查询 只能看到lock_flag=0的转租信息
     *
     * @param page           分页参数
     * @param subletInfoBody 查询参数
     * @return 分页结果
     */
    IPage<List<SubletInfoVo>> getSubletInfoVoPage(Page page, @Param("query") SubletInfoBody subletInfoBody);

    /**
     * 分页查询(含label）
     * 后台管理查询 可以看到违规的转租信息
     *
     * @param page           分页参数
     * @param subletInfoBody 查询参数
     * @return 分页结果
     */
    IPage<List<SubletInfoVo>> getSubletInfoVoPageMiddle(Page page, @Param("query") SubletInfoBody subletInfoBody);


    /**
     * 用户获取自己的发布列表
     *
     * @param page   分页参数
     * @param userId 用户id
     * @return 转租信息列表
     */
    List<SubletInfoVo> getSubletInfoByUserId(Page page, @Param("userId") String userId);



    /**
     * 获取转租信息相关接口 包括（用户信息，标签，评论等）
     *
     * @param id subletInfoId
     * @return subletInfoDetail
     */
    Object getSubletInfoDetailById(String id);
}
