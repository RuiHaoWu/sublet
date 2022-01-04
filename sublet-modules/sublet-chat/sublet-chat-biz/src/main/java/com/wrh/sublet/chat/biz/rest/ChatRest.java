package com.wrh.sublet.chat.biz.rest;

import com.wrh.sublet.common.core.result.R;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

/**
 * 聊天接口管理
 *
 * @author wrh
 * @date 2021/10/27
 */
@RestController
@Api(tags = "聊天接口管理")
@RequiredArgsConstructor
public class ChatRest {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/send")
    public R sendMsg(){
        // 消息全部先发送到这里，然后再通过 convertAndSend("/user/{id}",) 转发到给具体用户 地址前缀必须是要配置类 注册以/topic或者/user开头
        simpMessagingTemplate.convertAndSend("/user/{id}","发送什么");
        return R.ok();
    }
}
