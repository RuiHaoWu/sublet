package com.wrh.sublet.post.biz.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wrh.sublet.post.api.body.LabelBody;
import com.wrh.sublet.post.api.entity.Label;

import java.util.List;

/**
 * @author wrh
 * @date 2020/10/22
 */
public interface LabelService {
    /**
     * 根据id获取标签
     *
     * @param id labelId
     * @return label
     */
    Label getLabelById(Integer id);

    /**
     * 分页查询
     *
     * @param page      分页参数
     * @param labelBody 查询条件
     * @return page
     */
    Object getLabelPage(Page page, LabelBody labelBody);

    /**
     * 新增标签
     *
     * @param labelBody 标签实体
     * @return 操作结果
     */
    Boolean addLabel(LabelBody labelBody);

    /**
     * 删除标签
     *
     * @param id 标签id
     * @return 操作结果
     */
    Boolean deleteLabel(Integer id);

    /**
     * 获取标签列表
     *
     * @return 标签列表
     */
    List<Label> getLabelList();


    /**
     * 编辑标签
     *
     * @param id        labelId
     * @param labelBody body
     * @return 操作结果
     */
    Boolean editLabel(Integer id, LabelBody labelBody);


}
