package com.example.testmongo.controller;

import com.example.testmongo.entity.User;
import com.example.testmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/list")
    public void insertList(){
        userService.insertList();
    }

    @GetMapping("/")
    public void insert(){
        User user = new User("collection20","name20");
        userService.insert(user);
    }

    @GetMapping("/bachlish")
    public void insertRollback() throws Exception {
        userService.bathSave(true);
    }

    @GetMapping("/get")
    public void get(){
        userService.thread();
    }
}
