package com.example.dnf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class user {
    private int id;
    private String name;
    private double money;
    private String password;
}
