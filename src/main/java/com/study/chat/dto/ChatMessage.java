package com.study.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.messaging.Message;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChatMessage { // 채팅 메시지 객체
    public enum MessageType {
        ENTER, TALK
    }

    private MessageType type;
    private String roomId;
    private String sender;
    private String message;
}
