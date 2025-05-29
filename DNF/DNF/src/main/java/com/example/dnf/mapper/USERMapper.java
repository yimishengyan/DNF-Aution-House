package com.example.dnf.mapper;

import com.example.dnf.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface USERMapper{
    @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "userId")
    @Insert("INSERT INTO user (name, password, money) VALUES (#{name}, #{password}, #{money})")
    public int insertUser(User user);

    @Select("select userId, name, password, money, name, password, money, name, password, money from user")
    public List<User> showUser();

    @Select("select userId from user where name = #{name}")
    public Integer selectUserName(String name);

    @Select("select password from user where name = #{name}")
    public String selectUserPassword(String name);

    @Update("UPDATE user SET money = #{money} WHERE userId = #{userId}")
    public int changeMoney(int userId, double money);

    @Select("SELECT money FROM user WHERE userId = #{userId}")
    public Double selectMoney(int userId);

    @Delete("DELETE FROM user WHERE userId = #{userId}")
    public Integer deleteUser(Integer userId);

    @Select("SELECT * FROM user WHERE userId = #{userId}")
    public User showSingleUser(int userId);
}
