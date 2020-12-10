package com.example.testmongo.controller;

import com.example.testmongo.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BugController {
    @Autowired
    BugService bugService;

    @GetMapping("/bugList")
    public void insertList(int n) throws Exception {
        bugService.bugSave(n);
    }

    @GetMapping("/bug1")
    public void select(String id){
        bugService.findBug(id);
    }
}
