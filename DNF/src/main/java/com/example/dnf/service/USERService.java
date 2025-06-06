package com.example.dnf.service;

import com.example.dnf.entity.User;
import com.example.dnf.mapper.OBJECTMapper;
import com.example.dnf.mapper.USERMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class USERService {
    @Autowired
    private USERMapper userMapper;
    @Autowired
    private OBJECTMapper objectMapper;


    public String insertUser(User user) {
        int ret = userMapper.insertUser(user);
        System.out.println("回填的 user_id: " + user.getUserId());
        return ret > 0 ? "创建成功" : "创建失败";
    }

    public List<User> showUser(){
        return userMapper.showUser();
    }

    public User selectUserName(String name) {
        return userMapper.selectUserName(name);
    }

    public String selectUserPassword(User user) {
        String ret = userMapper.selectUserPassword(user.getName());
        if(ret == null) return "无该账号";
        return ret.equals(user.getPassword()) ? "登录成功" : "登陆失败";
    }

    public String deleteUser(Integer userId){
        int ret = userMapper.deleteUser(userId);
        objectMapper.deleteObject(userId);
        return ret > 0 ? "删除成功" : "删除失败，没有该用户";
    }

    public User showSingleUser(int userId){
        return userMapper.showSingleUser(userId);
    }

    public String changeMoney(Integer userId, Double money){
        Double ret = userMapper.selectMoney(userId);
        userMapper.changeMoney(userId, money + ret);
        return ret > 0 ? "充值成功" : "充值失败";
    }
}
