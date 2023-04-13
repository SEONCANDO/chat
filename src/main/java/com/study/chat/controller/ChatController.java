package com.study.chat.controller;

import com.study.chat.dto.ChatMessage;
import com.study.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.WebSocketSession;

@RequiredArgsConstructor
@RestController
public class ChatController {
    private final ChatService chatService;
    private final SimpMessagingTemplate template;

    @MessageMapping("/chat/enter")
    public void enter(WebSocketSession session, ChatMessage message, ChatService service){
        System.out.println("연결 성공");
        if(ChatMessage.MessageType.ENTER.equals(message.getType())){
            message.setMessage(message.getSender()+"님이 입장하였습니다.");
        }
        template.convertAndSend("/sub/chat/room/"+message.getRoomId(), message);
    }
    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }

    @RequestMapping("/greetings")
    public void greet(String greetingMessage){
        template.convertAndSend("/sub/chat/message", greetingMessage);
    }

}
