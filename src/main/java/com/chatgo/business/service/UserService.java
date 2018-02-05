package com.chatgo.business.service;

import com.chatgo.business.entity.RoomUser;
import com.chatgo.business.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface UserService {

    User save(User user ,MultipartFile file) throws IOException;

    User findOne(Long id);


    Page<User> findAll(Pageable pageable);

    byte[] downloadProfilePhoto(Long userId) throws IOException;

}
