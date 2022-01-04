package com.wrh.sublet.common.core.constants;

/**
 * @author wrh
 * @date 2021/10/13
 */
public interface CommonConstants {

    /**
     * 成功标记
     */
    Integer SUCCESS = 0;

    /**
     * 失败标志
     */
    Integer FAIL = -1;

    /**
     * 删除
     */
    Integer STATUS_DEL = 1;

    /**
     * 正常
     */
    Integer STATUS_NORMAL = 0;

    /**
     * 锁定
     */
    Integer STATUS_LOCKED = 1;

    /**
     * 招租
     */
    Integer SUBLET_ING = 0;

    /**
     * 已租
     */
    Integer SUBLET_ED = 1;

    /**
     * 权限父id
     */
    Integer AUTHORITY_ROOT = -1;

    /**
     * 评论父id
     */
    Integer COMMENT_ROOT = -1;

    /**
     * 默认密码
     */
    String DEFAULT_PASSWORD = "sublet123456";
}
