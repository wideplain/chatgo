package com.chatgo.security;

import com.chatgo.business.entity.User;
import org.springframework.security.core.authority.AuthorityUtils;

public class LoginUserDetails extends org.springframework.security.core.userdetails.User{

    private Long userId;
    private String userNickname;


    public LoginUserDetails(User user) {
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
        this.userId = user.getId();
        this.userNickname = user.getNickname();
    }

    public Long getUserId() {
        return userId;
    }
    public String getUserNickname() {
        return userNickname;
    }

}