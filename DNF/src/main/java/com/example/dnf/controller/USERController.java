package com.example.dnf.controller;


import com.example.dnf.entity.User;
import com.example.dnf.service.USERService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class USERController {
    @Autowired
    private USERService userService;

    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public String insertUser(@RequestBody User user){
        if(userService.selectUserName(user.getName()) == 0)
            return userService.insertUser(user);
        else return "用户已存在，请修改用户名";
    }

    @RequestMapping(value = "/showUser", method = RequestMethod.GET)
    public List<User> showUser(){
        return userService.showUser();
    }

    @RequestMapping(value = "/selectUser", method = RequestMethod.POST)
    public String selectUser(@RequestBody User user){
        return userService.selectUserPassword(user);
    }
}
