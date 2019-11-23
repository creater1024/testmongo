package com.example.testmongo.controller;

import com.example.testmongo.service.MavenCentralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MavenCentralController {
    @Autowired
    MavenCentralService mavenCentralService;

    @GetMapping("/exchange")
    public void exchangeDate(int n) throws Exception {
        mavenCentralService.mavenCentralSave(n);
    }
}
