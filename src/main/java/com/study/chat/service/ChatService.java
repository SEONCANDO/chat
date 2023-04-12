package com.study.chat.service;

import com.study.chat.dto.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.EventPublishingRunListener;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@RequiredArgsConstructor
@Service
public class ChatService {
    private Map<String, ChatRoom> chatRooms;

    @PostConstruct //의존성 주입 후 초기화할 때 사용
    private void init(){
        chatRooms = new LinkedHashMap<>();
    }

    //채팅방 불러오기
    public List<ChatRoom> findAllRoom(){
        //채팅방 최근 생성순으로 반환
        List<ChatRoom> result = new ArrayList<>(chatRooms.values());
        Collections.reverse(result);

        return result;
    }

    //채팅방 하나 불러오기
    public ChatRoom findById(String roomId){
        return chatRooms.get(roomId);
    }

    //채팅방 생성
    public ChatRoom createRoom(String name){
        ChatRoom chatRoom = ChatRoom.create(name);
        chatRooms.put(chatRoom.getRoomId(), chatRoom);
        return chatRoom;
    }

}
