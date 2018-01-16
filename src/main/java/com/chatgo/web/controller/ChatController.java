package com.chatgo.web.controller;


import com.chatgo.business.Service.RoomService;
import com.chatgo.business.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/")
    public String index(Pageable pageable, Model model) {
        Page<Room> rooms = roomService.findAll(pageable);
        model.addAttribute("rooms", rooms);
        return "chat/index";
    }


}
