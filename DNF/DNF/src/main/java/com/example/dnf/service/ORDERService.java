package com.example.dnf.service;

import com.example.dnf.entity.Order;
import com.example.dnf.entity.OrderDetail;
import com.example.dnf.mapper.ORDERMapper;
import com.example.dnf.mapper.USERMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ORDERService {
    @Autowired
    ORDERMapper orderMapper;
    USERMapper userMapper;

    public String insertOrder(Order order) {
        Double ret1 = userMapper.selectMoney(order.getBuyerId());
        Double ret2 = userMapper.selectMoney(order.getSellerId());
        if(ret1 == null || ret2 == null)  return "无该用户";
        if(ret1 < order.getValue())return "用户金额不足";
        userMapper.changeMoney(order.getBuyerId(), ret1 - order.getValue());
        userMapper.changeMoney(order.getSellerId(), ret1 + order.getValue());
        int ret = orderMapper.insertOrder(order);
        return ret > 0 ? "交易成功" : "交易失败";
    }

    public OrderDetail showOrder(Integer orderId) {
        return orderMapper.getOrderDetails(orderId);
    }
}
