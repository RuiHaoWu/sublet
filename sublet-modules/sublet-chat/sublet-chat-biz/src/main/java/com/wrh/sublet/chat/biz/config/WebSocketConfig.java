package com.wrh.sublet.chat.biz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * wWebSocket 配置类
 * <p>
 * @EnableWebSocketMessageBroker 开启使用STOMP协议来传输基于代理（message broker）的消息，配合@MessageMapping使用
 *
 * @author wrh
 * @date 2021/10/27
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        registry.enableSimpleBroker("/topic","/user");


        registry.setApplicationDestinationPrefixes("/chat");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        /*
         *  "/websocket"注册为stomp端点,对外暴露,客户端通过其建来websocket链接
         */
        registry.addEndpoint("/websocket").setAllowedOrigins("*").withSockJS();
    }
}
