package com.example.dnf.mapper;

import com.example.dnf.entity.OrderDetail;
import com.example.dnf.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RestController;

public interface ORDERMapper {
    @Options(useGeneratedKeys = true, keyProperty = "orderId", keyColumn = "orderId")
    @Insert("INSERT INTO order (objectId, buyerId, sellerId, value) VALUES (#{objectId}, #{buyerId}, #{sellerId}, #{value})")
    public int insertOrder(Order order);

    @Select("""
        SELECT 
            o.object_id AS objectId,
            obj.name AS objectName,
            buyer.name AS buyerName,
            seller.name AS sellerName,
            o.value
        FROM 
            order o
        JOIN 
            object obj ON o.object_id = obj.object_id
        JOIN 
            user buyer ON o.buyer_id = buyer.user_id
        JOIN 
            user seller ON o.seller_id = seller.user_id
        WHERE 
            o.order_id = #{orderId}
        """)
    OrderDetail getOrderDetails(@Param("orderId") int orderId);
}
