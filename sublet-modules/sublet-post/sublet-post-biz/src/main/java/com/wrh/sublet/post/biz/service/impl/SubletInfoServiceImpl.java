package com.wrh.sublet.post.biz.service.impl;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wrh.sublet.common.core.constants.CommonConstants;
import com.wrh.sublet.common.core.exception.BizException;
import com.wrh.sublet.post.api.body.SubletInfoBody;
import com.wrh.sublet.post.api.entity.SubletInfo;
import com.wrh.sublet.post.api.entity.SubletInfoLabel;
import com.wrh.sublet.post.api.vo.SubletInfoVo;
import com.wrh.sublet.post.biz.mapper.SubletInfoLabelMapper;
import com.wrh.sublet.post.biz.mapper.SubletInfoMapper;
import com.wrh.sublet.post.biz.service.SubletInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 转租信息 实现类
 *
 * @author wrh
 * @date 2021/10/20
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SubletInfoServiceImpl implements SubletInfoService {

    private final SubletInfoMapper subletInfoMapper;
    private final SubletInfoLabelMapper subletInfoLabelMapper;

    /**
     * 用户发布转租信息
     *
     * @param subletInfoBody 转租信息
     * @return 操作结果
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Boolean addSubletInfo(String userId, SubletInfoBody subletInfoBody) {
        SubletInfo subletInfo = new SubletInfo();
        BeanUtils.copyProperties(subletInfoBody, subletInfo);
        subletInfo.setUserId(userId);
        subletInfo.setLockFlag(CommonConstants.STATUS_NORMAL);
        subletInfo.setStatus(CommonConstants.SUBLET_ING);
        subletInfo.setCreateTime(System.currentTimeMillis());

        String[] images = Optional.ofNullable(subletInfoBody.getImages()).orElse(new String[]{});
        JSONObject json = JSONUtil.createObj()
                .set("images", images);
        subletInfo.setImages(JSONUtil.toJsonStr(json));

        subletInfoMapper.insert(subletInfo);
        subletInfoBody.getLabels().stream()
                .map(labelId -> {
                    SubletInfoLabel subletInfoLabel = new SubletInfoLabel();
                    subletInfoLabel.setSubletInfoId(subletInfo.getSubletInfoId());
                    subletInfoLabel.setLabelId(labelId);
                    return subletInfoLabel;
                })
                .forEach(subletInfoLabelMapper::insert);
        return Boolean.TRUE;
    }

    /**
     * 编辑转租信息
     *
     * @param subletInfoBody 转租信息
     * @return 操作结果
     */
    @Override
    public Boolean editSubletInfo(String subletInfoId, SubletInfoBody subletInfoBody, String userId) {
        SubletInfo subletInfo = subletInfoMapper.selectById(subletInfoId);
        if (Objects.isNull(subletInfo)) {
            throw new BizException(subletInfoId + "不存在");
        }
        if (!subletInfo.getUserId().equals(userId)) {
            throw new BizException("不允许编辑其他人的帖子信息");
        }
        BeanUtils.copyProperties(subletInfoBody, subletInfo);
        subletInfoMapper.updateById(subletInfo);
        return Boolean.TRUE;
    }

    /**
     * 违规信息锁定，不让其展示
     *
     * @param id subletInfoId
     * @return 操作结果
     */
    @Override
    public Boolean lockSubletInfo(String id) {
        SubletInfo subletInfo = this.getSubletInfoById(id);
        Integer lockFlag = subletInfo.getLockFlag().equals(CommonConstants.STATUS_NORMAL) ? CommonConstants.STATUS_LOCKED : CommonConstants.STATUS_NORMAL;
        subletInfo.setLockFlag(lockFlag);
        subletInfoMapper.updateById(subletInfo);
        return Boolean.TRUE;
    }

    /**
     * 修改转租状态 已转/招租
     *
     * @param id subletInfoId
     * @return 操作结果
     */
    @Override
    public Boolean statusSubletInfo(String id, String userId) {
        SubletInfo subletInfo = this.getSubletInfoById(id);
        if (!userId.equals(subletInfo.getUserId())) {
            throw new BizException("只允许修改自己发布的帖子状态");
        }
        Integer status = subletInfo.getLockFlag().equals(CommonConstants.SUBLET_ING) ? CommonConstants.SUBLET_ED : CommonConstants.SUBLET_ING;
        subletInfo.setStatus(status);
        subletInfoMapper.updateById(subletInfo);
        return Boolean.TRUE;
    }

    /**
     * 用户获取自己的发布列表
     *
     * @param page   分页参数
     * @param userId 用户id
     * @return 转租信息列表
     */
    @Override
    public List<SubletInfoVo> getSubletInfoByUserId(Page page, String userId) {
        page.setOrders(OrderItem.descs("create_time"));
        return subletInfoMapper.getSubletInfoByUserId(page, userId);
    }

    /**
     * 分页获取转租信息
     * 只能查询到合法不被锁定的转租信息
     *
     * @param page           分页参数
     * @param subletInfoBody 搜索条件
     * @return page
     */
    @Override
    public Object pageSubletInfo(Page page, SubletInfoBody subletInfoBody) {
        return subletInfoMapper.getSubletInfoVoPage(page, subletInfoBody);
    }

    /**
     * 管理端的分页查询,可以看到违规转租信息
     *
     * @param page           分页参数
     * @param subletInfoBody 查询参数
     * @return 列表
     */
    @Override
    public Object pageSubletInfoMiddle(Page page, SubletInfoBody subletInfoBody) {
        page.setOrders(OrderItem.descs("create_time"));
        return subletInfoMapper.getSubletInfoVoPageMiddle(page, subletInfoBody);
    }

    @Override
    public Object getSubletInfoDetailById(String id) {
        return subletInfoMapper.getSubletInfoDetailById(id);
    }


    private SubletInfo getSubletInfoById(String subletInfoId) {
        SubletInfo subletInfo = subletInfoMapper.selectById(subletInfoId);
        if (Objects.isNull(subletInfo)) {
            throw new BizException("请检查id是否有误");
        }
        return subletInfo;
    }
}
