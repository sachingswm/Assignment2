package com.example.assignment2.controller;

import com.example.assignment2.entity.User;
import com.example.assignment2.helper.FileHandler;
import com.example.assignment2.service.abstraction.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @Autowired
    private FileHandler fileHandler;

    @GetMapping("/")
    public ModelAndView fileUploadForm() {
        System.out.println("Hi");
        return new ModelAndView("FileUpload");
    }

    @PostMapping(value = "/saveUser")
    public ModelAndView saveUser(@RequestParam("excel") MultipartFile multipartFile) throws Throwable {
        List<User> users = FileHandler.convertFileTOListOfUser(multipartFile);
        for (User user : users)
            userDaoService.saveUser(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ResultPage");
        modelAndView.addObject("users", users);
        return modelAndView;
    }
}
