package com.chatgo.web.controller;

import com.chatgo.business.entity.User;
import com.chatgo.business.service.RoomService;
import com.chatgo.business.entity.Room;
import com.chatgo.business.service.UserService;
import com.chatgo.web.form.RoomForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * ルームの作成
 */
@Controller
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserService userService;

    @ModelAttribute
    RoomForm setUpForm() {
        return new RoomForm();
    }

    @GetMapping("/rooms/new")
    public String newRoom(RoomForm form, Model model, Pageable pageable) {
        Page<User> users = userService.findAll(pageable);
        model.addAttribute("users", users);
        return "room/new";
    }


    @PostMapping("/rooms/new")
    public String createRoom(@Validated RoomForm form, BindingResult result, Model model, Pageable pageable) {
        if (result.hasErrors()) {
            return newRoom(form, model, pageable);
        }
        Room room = new Room();
        BeanUtils.copyProperties(form, room);
        roomService.save(room);
        return "redirect:/rooms/{room.id}/messages";
    }

    @GetMapping("/rooms/search")
    public String search(@RequestParam(defaultValue = "") String keyword, Model model) {
        List<Room> rooms = roomService.findAllByNameLike(keyword);
        model.addAttribute("rooms", rooms);
        return "room/search";
    }
}
