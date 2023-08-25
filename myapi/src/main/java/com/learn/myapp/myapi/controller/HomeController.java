package com.learn.myapp.myapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/status")
    public String home(){
        return "API is up and Running";
    }
    
}
