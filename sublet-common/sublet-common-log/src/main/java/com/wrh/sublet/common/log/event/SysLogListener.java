package com.wrh.sublet.common.log.event;

import com.wrh.sublet.common.core.constants.SecurityConstants;
import com.wrh.sublet.user.api.entity.SysLog;
import com.wrh.sublet.user.api.feign.RemoteLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

/**
 * 事件监听
 * @author wrh
 * @date 2021/11/9
 */
@RequiredArgsConstructor
public class SysLogListener {

    private final RemoteLogService remoteLogService;

    @Async
    @Order
    @EventListener(SysLogEvent.class)
    public void saveSysLog(SysLogEvent event) {
        SysLog sysLog = (SysLog) event.getSource();
        remoteLogService.saveLog(sysLog, SecurityConstants.FROM_IN);
    }
}
