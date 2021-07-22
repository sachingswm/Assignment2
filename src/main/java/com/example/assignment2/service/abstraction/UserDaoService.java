package com.example.assignment2.service.abstraction;

import com.example.assignment2.entity.User;
import org.springframework.stereotype.Service;


public interface UserDaoService {
    public User saveUser(User user);
}
