package com.example.dnf.controller;


import com.example.dnf.entity.User;
import com.example.dnf.service.USERService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class USERController {
    @Autowired
    private USERService userService;

    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public String insertUser(@RequestBody User user){
        if(userService.selectUserName(user.getName()).getUserId() == 0)
            return userService.insertUser(user);
        else return "用户已存在，请修改用户名";
    }

    @RequestMapping(value = "/showUser", method = RequestMethod.GET)
    public List<User> showUser(){
        return userService.showUser();
    }

    @RequestMapping(value = "/selectUser", method = RequestMethod.POST)
    public String selectUserPassword(@RequestBody User user){
        return userService.selectUserPassword(user);
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public String deleteUser(@RequestBody User user){
        System.out.println("删除用户" + user);
        return userService.deleteUser(user.getUserId());
    }

    @RequestMapping(value = "/selectSingleUser", method = RequestMethod.GET)
    public User showSingleUser(@RequestParam Integer userId){
        System.out.println("展示单一用户" + userId);
        return userService.showSingleUser(userId);
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public User getUserInfo(@RequestParam String name){
        System.out.println("登陆时提供cookie: " + name);
        User ret = userService.selectUserName(name);
        System.out.println("ret: " + ret);
        return ret;
    }
}
