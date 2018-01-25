package com.chatgo.business.service.impl;

import com.chatgo.business.entity.User;
import com.chatgo.business.repository.UserRepository;
import com.chatgo.security.LoginUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        Set<GrantedAuthority> grantedAutorities = new HashSet<>();

        if (user == null) {
            throw new UsernameNotFoundException("No user found with email: " + email);
        }
        return new LoginUserDetails(user);
    }

}