package com.example.testmongo.controller;

import com.example.testmongo.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BugController {
    @Autowired
    BugService bugService;
//    @GetMapping("/bug")
//    public void insert(int n){
//        bugService.insert(n);
//    }
//
//    @GetMapping("/bugList")
//    public void insertList(int n) throws Exception {
//        bugService.bugSave(n);
//    }

    @GetMapping("/bug1")
    public void select(){
        bugService.findBug();
    }
    @GetMapping("/bugtest")
    public void test(int num){
        for(int i=0;i<num;i++){
            bugService.test();
        }
    }
}
