package com.example.dnf.controller;

import com.example.dnf.entity.user;
import com.example.dnf.mapper.USERMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class USERController {
    @Autowired
    private USERMapper userMapper;

    @RequestMapping(value = "/insertUser")
    public String insertUser(@RequestBody user u){
        try {
            int result = userMapper.insert(u); // 调用MyBatis Mapper方法[3](@ref)
            return result > 0 ? "插入成功" : "插入失败";
        } catch (Exception e) {
            e.printStackTrace();
            return "服务器异常：" + e.getMessage();
        }
    }


}
