package com.chatgo.web.controller;


import com.chatgo.business.entity.Message;
import com.chatgo.business.service.MessageService;
import com.chatgo.business.service.RoomService;
import com.chatgo.business.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private MessageService messageService;


    @GetMapping("/")
    public String index(@PageableDefault(
            page = 0,
            size = 100,
            direction = Sort.Direction.ASC,
            sort = {"createdAt"}
                    )Pageable pageable, Model model) {
        Page<Room> rooms = roomService.findAll(pageable);
        Page<Message> messages = messageService.findAll(pageable);
        model.addAttribute("rooms", rooms);
        model.addAttribute("messages", messages);
        return "chat/index";
    }


}
