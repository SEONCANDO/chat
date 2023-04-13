package com.study.chat.controller;

import com.study.chat.dto.ChatRoom;
import com.study.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/chat")
@RequiredArgsConstructor
@Controller
public class ChatRoomController {
    private final ChatService chatService;

    //채팅 리스트 화면
    @GetMapping("/room")
    public String rooms(Model model){
        return "/view/room";
    }

    //모든 채팅방 목록 조회
    @GetMapping("/rooms")
    @ResponseBody
    public List<ChatRoom> room(){
        return chatService.findAllRooms();
    }

    //채팅방 개설
    @PostMapping("/room")
    @ResponseBody
    public ChatRoom createRoom(@RequestParam String name){
        return chatService.createRoom(name);
    }

    //채팅방 입장 화면
    @GetMapping("/room/enter/{room_id}")
    public String roomDetail(Model model, @PathVariable String room_id){
        model.addAttribute("room_id", room_id);
        return "/view/room";
    }

    //특정 채팅방 조회
    @GetMapping("/room/{room_id}")
    @ResponseBody
    public ChatRoom roomInfo(@PathVariable String room_id){
        return chatService.findById(room_id);
    }
}
