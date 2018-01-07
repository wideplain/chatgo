package com.chatgo.web.controller;

import com.chatgo.business.Service.RoomService;
import com.chatgo.business.entitiy.Room;
import com.chatgo.web.form.RoomForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * ルームの作成
 */
@Controller
public class RoomController {

    @ModelAttribute
    RoomForm setUpForm() {
        return new RoomForm();
    }

    @GetMapping("/rooms/new")
    public String newRoom(RoomForm form, Model model) {
        return "room/new";
    }

    @Autowired
    private RoomService roomService;

    @PostMapping("/rooms/new")
    public String createRoom(@Validated RoomForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return newRoom(form, model);
        }
        Room room = new Room();
        BeanUtils.copyProperties(form, room);
        roomService.save(room);
        return "redirect:/";
    }


}
