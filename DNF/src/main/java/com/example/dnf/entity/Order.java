package com.example.dnf.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@TableName("order")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    Integer orderId;
    Integer objectId;
    Integer buyerId;
    Integer sellerId;
    Double value;
}
