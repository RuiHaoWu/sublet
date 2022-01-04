package com.wrh.sublet.common.log.event;

import com.wrh.sublet.user.api.entity.SysLog;
import org.springframework.context.ApplicationEvent;

/**
 * @author wrh
 * @date 2021/11/9
 */
public class SysLogEvent extends ApplicationEvent {

    public SysLogEvent(SysLog source) {
        super(source);
    }
}
