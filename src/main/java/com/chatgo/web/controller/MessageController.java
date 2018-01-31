package com.chatgo.web.controller;

import com.chatgo.business.entity.Message;
import com.chatgo.business.service.MessageService;
import com.chatgo.business.service.RoomService;
import com.chatgo.business.entity.Room;
import com.chatgo.security.LoginUserDetails;
import com.chatgo.web.form.MessageForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MessageController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private MessageService messageService;

    @ModelAttribute
    MessageForm setUpForm() {
        return new MessageForm();
    }

    @GetMapping("/rooms/{roomId}/messages")
    public String messageIndex(MessageForm form, Pageable pageable, Model model,  @PathVariable Long roomId) {
        Room room = roomService.findOne(roomId);
        Page<Room> rooms = roomService.findAll(pageable);
        model.addAttribute("room", room);
        model.addAttribute("rooms", rooms);
        return "chat/index";
    }

    @PostMapping("/rooms/{roomId}/messages")
    public String createMessage(@Validated MessageForm form, BindingResult result, Pageable pageable, Model model, @PathVariable Long roomId, @AuthenticationPrincipal LoginUserDetails loginUserDetails) {
        if (result.hasErrors()) {
            return messageIndex(form, pageable, model, roomId);
        }
        Message message = new Message();
        BeanUtils.copyProperties(form, message);
        messageService.save(message, roomId, loginUserDetails.getUserId());
        return "redirect:/";
    }
}
