package com.example.dnf.service;

import com.example.dnf.entity.User;
import com.example.dnf.mapper.USERMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class USERService {
    @Autowired
    private USERMapper userMapper;


    public String insertUser(User user) {
        int ret = userMapper.insertUser(user);
        System.out.println("回填的 user_id: " + user.getUserId());
        return ret > 0 ? "创建成功" : "创建失败";
    }

    public List<User> showUser(){
        return userMapper.showUser();
    }

    public Integer selectUserName(String name) {
        int ret = userMapper.selectUserName(name);
        return ret > 0 ? ret : 0;
    }
}
