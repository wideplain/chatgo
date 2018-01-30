package com.chatgo.web.controller;

import com.chatgo.business.entity.User;
import com.chatgo.business.repository.UserRepository;
import com.chatgo.business.service.UserService;
import com.chatgo.security.LoginUserDetails;
import com.chatgo.web.form.UserForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserDetailsService userDetailsService;


    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String loginForm(@AuthenticationPrincipal LoginUserDetails loginUserDetails) {
        if (loginUserDetails != null) {
            return "redirect:/";
        }
        return "user/login";
    }

    @GetMapping("/sign_up")
    public String signupForm(UserForm form,
                             @AuthenticationPrincipal LoginUserDetails loginUserDetails) {
        if (loginUserDetails != null) {
            return "redirect:/";
        }
        return "user/signup";
    }

    @PostMapping("/sign_up")
    public String register(@Validated UserForm form,
                           BindingResult result,
                           Model model,
                           @AuthenticationPrincipal LoginUserDetails loginUserDetails){
        if (loginUserDetails != null) {
            return "redirect:/";
        }
        if (!form.getPassword().equals(form.getConfirmPassword())) {
            result.rejectValue("password", "error.passwordConfirmation", "do not match.");
        }
        if (result.hasErrors()) {
            return "user/signup";
        }
        User user = new User();
        BeanUtils.copyProperties(form, user);
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/users/{id}")
    public String show(@PathVariable Long id, Model model) {
        User user = userService.findOne(id);
        model.addAttribute("user", user);
        return "user/show";
    }

    @GetMapping("/users/{id}/edit")
    public ModelAndView editUser(@PathVariable("id") Long id, ModelAndView mav, Model model, UserForm form, @AuthenticationPrincipal LoginUserDetails loginUserDetails) {
        User user = userService.findOne(id);
        mav.addObject("user", user);
        mav.setViewName("user/edit");
        return mav;
    }

    @PostMapping("/users/{id}/edit")
    public ModelAndView updateUser(@PathVariable("id") Long id, ModelAndView mav, @Validated UserForm form, BindingResult result, Model model, @AuthenticationPrincipal LoginUserDetails loginUserDetails) {
        User user = userService.findOne(id);
        BeanUtils.copyProperties(form, user);
        userService.save(user);
        mav.setViewName("redirect:/");
        return mav;
    }


}