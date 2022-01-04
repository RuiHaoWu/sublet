package com.wrh.sublet.post.biz.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wrh.sublet.common.core.result.R;
import com.wrh.sublet.post.api.body.SubletInfoBody;
import com.wrh.sublet.post.api.entity.SubletInfo;
import com.wrh.sublet.post.api.vo.SubletInfoVo;

import java.util.List;

/**
 * @author wrh
 * @date 2021/10/20
 */
public interface SubletInfoService {

    /**
     * 添加转租信息
     * @param userId 用户Id
     * @param subletInfoBody 转租信息
     * @return 操作结果
     */
    Boolean addSubletInfo(String userId,SubletInfoBody subletInfoBody);

    /**
     * 编辑转租信息
     *
     * @param subletInfoBody 转租信息
     * @return 操作结果
     */
    Boolean editSubletInfo(String id, SubletInfoBody subletInfoBody,String userId);

    /**
     * 违规信息锁定，不让其展示
     *
     * @param id subletInfoId
     * @return 操作结果
     */
    Boolean lockSubletInfo(String id);

    /**
     * 修改转租状态 已转/招租
     *
     * @param id subletInfoId
     * @param userId 用户id
     * @return 操作结果
     */
    Boolean statusSubletInfo(String id, String userId);

    /**
     * 用户获取自己的发布列表
     *
     * @param page   分页参数
     * @param userId 用户id
     * @return 转租信息列表
     */
    List<SubletInfoVo> getSubletInfoByUserId(Page page, String userId);

    /**
     * 分页获取转租信息
     *
     * @param page           分页参数
     * @param subletInfoBody 搜索条件
     * @return page
     */
    Object pageSubletInfo(Page page, SubletInfoBody subletInfoBody);

    /**
     * 管理端的分页查询,可以看到违规转租信息
     *
     * @param page           分页参数
     * @param subletInfoBody 查询参数
     * @return 列表
     */
    Object pageSubletInfoMiddle(Page page, SubletInfoBody subletInfoBody);

    /**
     * 根据id获取详细信息
     *
     * @param id subletInfoId
     * @return subletInfoVo
     */
    Object getSubletInfoDetailById(String id);
}
