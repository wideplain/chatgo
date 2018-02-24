package com.chatgo.web.controller;

import com.chatgo.business.entity.Message;
import com.chatgo.business.entity.SocketMessage;
import com.chatgo.business.entity.User;
import com.chatgo.business.service.MessageService;
import com.chatgo.business.service.RoomService;
import com.chatgo.business.entity.Room;
import com.chatgo.business.service.RoomUserService;
import com.chatgo.business.service.UserService;
import com.chatgo.security.LoginUserDetails;
import com.chatgo.web.form.MessageForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @Autowired
    private UserService userService;

    @Autowired
    private RoomUserService roomUserService;

    @ModelAttribute
    MessageForm setUpForm() {
        return new MessageForm();
    }

    @GetMapping("/rooms/{roomId}/messages")
    public String messageIndex (MessageForm form, @PageableDefault(
            size = 100,
            direction = Sort.Direction.ASC,
            sort = {"createdAt"})Pageable pageable, Model model, @PathVariable Long roomId,  @AuthenticationPrincipal LoginUserDetails loginUserDetails) {
        Room room = roomService.findOne(roomId);
        List<Room> rooms = roomService.ifUserSignIn(loginUserDetails, pageable, model);
        List<Message> messages = messageService.findAllByRoomId(roomId, pageable);
        model.addAttribute("room", room);
        model.addAttribute("rooms", rooms);
        model.addAttribute("messages", messages);
        return "chat/index";
    }



    @MessageMapping("/{roomId}/messages/post")
    @SendTo("/rooms/{roomId}/messages")
    public SocketMessage createMessage(@Validated MessageForm form, @AuthenticationPrincipal LoginUserDetails loginUserDetails, @PathVariable("roomId") Long roomId) {
        Message newMessage = new Message();
        BeanUtils.copyProperties(form, newMessage);
        messageService.save(newMessage,loginUserDetails.getUserId(), roomId);
        return new SocketMessage(form.getBody(), loginUserDetails.getUserNickname(), "a", loginUserDetails.getUserId());
    }

}
