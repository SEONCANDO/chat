package com.study.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@Data
public class ChatRoom { //채팅방 객체
    private String room_id;
    private String room_name;
    private Set<WebSocketSession> sessions = new HashSet<>();

    public ChatRoom(String room_id, String room_name){
        this.room_name = room_name;
        this.room_id = room_id;
    }

    public static ChatRoom create(String name){
        ChatRoom room = new ChatRoom();
        room.room_id = UUID.randomUUID().toString();
        room.room_name = name;
        return room;
    }
}
