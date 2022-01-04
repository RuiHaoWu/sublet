package com.wrh.sublet.common.log.aspect;

import com.wrh.sublet.common.core.exception.BizException;
import com.wrh.sublet.common.log.event.SysLogEvent;
import com.wrh.sublet.common.log.enums.LogTypeEnum;
import com.wrh.sublet.common.log.util.SysLogUtils;
import com.wrh.sublet.common.web.utils.SpringContextHolder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author WRH
 * @date 2021/10/8
 */
@Slf4j
@Aspect
public class SysLogAspect {


    @Around("@annotation(sysLog)")
    @SneakyThrows
    public Object around(ProceedingJoinPoint point, com.wrh.sublet.common.log.annotation.SysLog sysLog) {
        com.wrh.sublet.user.api.entity.SysLog logVo = SysLogUtils.getSysLog();
        logVo.setTitle(sysLog.value());

        Long startTime = System.currentTimeMillis();
        Object obj = null;

        try {
            obj = point.proceed();
        } catch (Throwable throwable) {
            log.error(throwable.getMessage());
            logVo.setType(LogTypeEnum.ERROR.getType());
            logVo.setErrorMsg(throwable.getMessage());
            throw new BizException(throwable.getMessage());
        } finally {
            Long endTime = System.currentTimeMillis();
            logVo.setExecTime(endTime - startTime);
            SpringContextHolder.publishEvent(new SysLogEvent(logVo));
        }
        return obj;
    }

}
