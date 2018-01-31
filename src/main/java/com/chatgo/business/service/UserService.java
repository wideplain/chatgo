package com.chatgo.business.service;

import com.chatgo.business.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {

    User save(User user ,MultipartFile file) throws IOException;

    User findOne(Long id);

    byte[] downloadProfilePhoto(Long userId) throws IOException;


}
