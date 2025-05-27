package com.example.dnf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName(value = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userId;

    private String name;
    private String password;
    private double money;
}
