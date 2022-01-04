package com.wrh.sublet.common.log.annotation;

import java.lang.annotation.*;

/**
 * @author WRH
 * @date 2020/10/8 操作日志注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    /**
     * 描述
     * @return {String}
     */
    String value();
}
