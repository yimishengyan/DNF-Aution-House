package com.example.dnf.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TESTController {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World！！！！！！！！！！！！！！！！！！！！！！！！！！！";
    }
}
