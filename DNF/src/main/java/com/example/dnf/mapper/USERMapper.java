package com.example.dnf.mapper;

import com.example.dnf.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface USERMapper{
    @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "userId")
    @Insert("INSERT INTO user (name, password, money) VALUES (#{name}, #{password}, #{money})")
    public int insertUser(User user);

    @Select("select userId, name, password, money, name, password, money, name, password, money from user")
    public List<User> showUser();

    @Select("select user_id from user where name = #{name}")
    public int selectUserName(String name);
}
