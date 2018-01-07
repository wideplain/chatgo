package com.chatgo.web.controller;

import com.chatgo.business.entitiy.Room;
import com.chatgo.business.repository.RoomRepository;
import com.chatgo.web.form.RoomForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ルームの作成
 */
@Controller
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @ModelAttribute
    RoomForm setUpForm() {
        return new RoomForm();
    }

    @GetMapping("/rooms/new")
    public ModelAndView newRoom(ModelAndView mav) {
        mav.setViewName("chat/newroom");
        return mav;
    }

    @PostMapping("/rooms/new")
    public ModelAndView createRoom(@ModelAttribute Room room, ModelAndView mav) {
        roomRepository.saveAndFlush(room);
        mav.setViewName("chat/index");
        return mav;
    }
}
