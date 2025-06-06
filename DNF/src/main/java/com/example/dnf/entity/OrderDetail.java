package com.example.dnf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    Integer orderId;
    String objectName;
    String buyerName;
    String sellerName;
    Double value;
}
