package com.example.dnf.mapper;

import com.example.dnf.entity.OrderDetail;
import com.example.dnf.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface ORDERMapper {
    @Options(useGeneratedKeys = true, keyProperty = "orderId", keyColumn = "orderId")
    @Insert("INSERT INTO `order` (objectId, buyerId, sellerId, value) VALUES (#{objectId}, #{buyerId}, #{sellerId}, #{value})")
    public int insertOrder(Order order);

    @Select("""
        SELECT 
            o.orderId,
            obj.name AS objectName,
            buyer.name AS buyerName,
            seller.name AS sellerName,
            o.value
        FROM 
            `order` o
        JOIN 
            object obj ON o.objectId = obj.objectId
        JOIN 
            user buyer ON o.buyerId = buyer.userId
        JOIN 
            user seller ON o.sellerId = seller.userId
        WHERE 
            buyer.userId = #{userId}
        """)
    List<OrderDetail> getOrderDetails(Integer userId);
}
