package com.study.chat.repository;

import com.study.chat.dto.ChatRoom;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatRoomRepository {
    void save(ChatRoom chatRoom);
}
