package com.example.assignment2.controller;

import com.example.assignment2.entity.User;
import com.example.assignment2.exception.NoUserExists;
import com.example.assignment2.exception.UserIncompleteDetails;
import com.example.assignment2.helper.FileHandler;
import com.example.assignment2.service.abstraction.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        return new ModelAndView("FileUpload");
    }

    @PostMapping(value = "/saveUser")
    public ModelAndView saveUser(@RequestParam("excel") MultipartFile multipartFile) throws Exception {
        List<User> users = FileHandler.convertFileTOListOfUser(multipartFile);
        if(users==null)
        {
            throw new NoUserExists("No User Exists");
        }
        for (User user : users) {
            try {
                if (user.getId() == null || user.getName() == null) {
                    throw new UserIncompleteDetails("Incomplete Details");
                }
            }
            catch (UserIncompleteDetails userIncompleteDetails)
            {

            }
            userDaoService.saveUser(user);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ResultPage");
        modelAndView.addObject("users", users);
        return modelAndView;
    }
}
