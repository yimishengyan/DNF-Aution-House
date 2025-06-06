package com.example.dnf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName(value = "administrator")
@AllArgsConstructor
@NoArgsConstructor
public class Administrator {
    private Integer administratorId;
    private String name;
    private String password;
}
