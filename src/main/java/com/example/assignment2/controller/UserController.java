package com.example.assignment2.controller;

import com.example.assignment2.entity.User;
import com.example.assignment2.helper.FileHandler;
import com.example.assignment2.service.abstraction.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @Autowired
    private FileHandler fileHandler;

    @RequestMapping("/")
    public ModelAndView fileUploadForm()
    {
        ModelAndView mv=new ModelAndView();
        mv.setViewName("FileUpload");
        return mv;

    }

    @PostMapping(value = "/saveUser",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<User> saveUser(@RequestPart(value = "file",required = true)MultipartFile multipartFile)throws Exception
    {
        List<User> users=FileHandler.convertFileTOListOfUser(multipartFile);
        for(User user:users)
            userDaoService.saveUser(user);
        return users;
    }
}
