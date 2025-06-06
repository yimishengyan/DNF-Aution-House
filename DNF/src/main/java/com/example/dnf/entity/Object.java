package com.example.dnf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@TableName("object")
@AllArgsConstructor
@NoArgsConstructor
public class Object {
    private Integer objectId;
    private String name;
    private String type;
    private Double value;
    private Integer ownerId;
    private String path = "path";
}
