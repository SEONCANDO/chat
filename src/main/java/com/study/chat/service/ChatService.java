package com.study.chat.service;

import com.study.chat.dto.ChatRoom;
import com.study.chat.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class ChatService {
    private final ChatRoomRepository chatRoomRepository;

    //채팅방 불러오기
    public List<ChatRoom> findAllRooms(){
        //채팅방 최근 생성순으로 반환
        List<ChatRoom> result = new ArrayList<>(chatRooms.values());
        Collections.reverse(result);

        return result;
    }

    //채팅방 하나 불러오기
    public ChatRoom findById(String room_id){
        return chatRooms.get(room_id);
    }

    //채팅방 생성
    public ChatRoom createRoom(String room_name){
        ChatRoom chatRoom = ChatRoom.create(room_name);
        chatRooms.put(chatRoom.getRoom_id(), chatRoom);

        return chatRoom;
    }

}
