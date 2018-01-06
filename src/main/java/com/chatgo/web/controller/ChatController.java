package com.chatgo.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {
    @RequestMapping("/")
    public String index() {
        return "chat/index";
    }
}
