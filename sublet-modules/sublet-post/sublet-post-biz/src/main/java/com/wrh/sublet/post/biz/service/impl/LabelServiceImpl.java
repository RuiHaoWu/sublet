package com.wrh.sublet.post.biz.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wrh.sublet.common.core.exception.BizException;
import com.wrh.sublet.post.api.body.LabelBody;
import com.wrh.sublet.post.api.entity.Label;
import com.wrh.sublet.post.biz.mapper.LabelMapper;
import com.wrh.sublet.post.biz.service.LabelService;
import com.wrh.sublet.user.api.entity.SysLog;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 标签管理 实现类
 *
 * @author wrh
 * @date 2021/10/22
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LabelServiceImpl extends ServiceImpl<LabelMapper, Label> implements LabelService {

    private final LabelMapper labelMapper;

    @Override
    public Boolean addLabel(LabelBody labelBody) {
        Label label = new Label();
        label.setLabelName(labelBody.getLabelName());
        labelMapper.insert(label);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteLabel(Integer id) {
        Label label = this.getLabelById(id);
        labelMapper.deleteById(label);
        return Boolean.TRUE;
    }

    @Override
    public List<Label> getLabelList() {
        return labelMapper.selectList(Wrappers.emptyWrapper());
    }

    @Override
    public Boolean editLabel(Integer id, LabelBody labelBody) {
        Label label = this.getLabelById(id);
        label.setLabelName(labelBody.getLabelName());
        labelMapper.updateById(label);
        return Boolean.TRUE;
    }

    @Override
    public Object getLabelPage(Page page, LabelBody labelBody) {
        LambdaQueryWrapper<Label> wrapper = Wrappers.lambdaQuery();
        wrapper.like(StrUtil.isNotBlank(labelBody.getLabelName()), Label::getLabelName, labelBody.getLabelName());

        if (ArrayUtils.isNotEmpty(labelBody.getRangeTime())) {
            wrapper.ge(Label::getCreateTime, labelBody.getRangeTime()[0]).le(Label::getCreateTime, labelBody.getRangeTime()[1]);
        }

        return labelMapper.selectPage(page, wrapper);
    }


    @Override
    public Label getLabelById(Integer id) {
        Label label = labelMapper.selectById(id);
        if (Objects.isNull(label)) {
            throw new BizException("查询不到标签");
        }
        return label;
    }
}
