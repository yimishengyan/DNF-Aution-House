package com.example.dnf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjectDetail {
    Integer objectId;
    String name;
    Integer count;
    Double value;
}
