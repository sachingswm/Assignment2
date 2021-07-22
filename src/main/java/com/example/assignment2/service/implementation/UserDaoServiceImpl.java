package com.example.assignment2.service.implementation;

import com.example.assignment2.entity.User;
import com.example.assignment2.repository.UserDao;
import com.example.assignment2.service.abstraction.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDaoServiceImpl implements UserDaoService {

    @Autowired
    private UserDao userDao;

    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }
}
