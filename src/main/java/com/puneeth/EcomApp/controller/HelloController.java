package com.puneeth.EcomApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String greetings(){
        return "Welcome to ECom Application.";
    }
}
