package com.study.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@EnableWebSocketMessageBroker
@Configuration
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        // 처음 웹소켓 접속시 handshake와 통신 담당할 엔드포인트 지정
        registry.addEndpoint("/ws/chat").setAllowedOriginPatterns("*").withSockJS(); // 웹소켓 지원 x인 브라우저 sockJS 사용하도록
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){
        // 메세지 받을 때 경로 설정
        registry.enableSimpleBroker("/sub", "/topic");
        // 메세지 보낼 때 경로 설정
        registry.setApplicationDestinationPrefixes("/pub", "/app");
    }
/*    @Override
    // StompHandler가 웹소켓 앞단에서 token 체크가능하도록 인터셉터로 설정
    public void configureClientInboundChannel(ChannelRegistration registration){
        registration.interceptors(stompHandler);
    }*/

}
