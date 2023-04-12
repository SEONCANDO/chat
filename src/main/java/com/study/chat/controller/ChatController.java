package com.study.chat.controller;

import com.study.chat.dto.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ChatController {
    private final SimpMessageSendingOperations sendingOperations;

    @MessageMapping("/chat/message")
    public void enter(ChatMessage message){
        if(ChatMessage.MessageType.ENTER.equals(message.getType())){
            message.setMessage(message.getSender()+"님이 입장하였습니다.");
        }
        sendingOperations.convertAndSend("/topic/chat/room/"+message.getRoomId(), message);
    }
}
