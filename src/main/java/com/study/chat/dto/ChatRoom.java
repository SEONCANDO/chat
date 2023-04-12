package com.study.chat.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Data
public class ChatRoom { //채팅방 객체
    private String roomId;
    private String roomName;

    public static ChatRoom create(String name){
        ChatRoom room = new ChatRoom();
        room.roomId = UUID.randomUUID().toString();
        room.roomName = name;
        return room;
    }
}
