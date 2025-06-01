package com.example.dnf.service;

import com.example.dnf.entity.Order;
import com.example.dnf.entity.OrderDetail;
import com.example.dnf.mapper.OBJECTMapper;
import com.example.dnf.mapper.ORDERMapper;
import com.example.dnf.mapper.USERMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ORDERService {
    @Autowired
    ORDERMapper orderMapper;
    @Autowired
    USERMapper userMapper;
    @Autowired
    OBJECTMapper objectMapper;

    public String insertOrder(Order order) {
        Double ret1 = userMapper.selectMoney(order.getBuyerId());
        Double ret2 = userMapper.selectMoney(order.getSellerId());
        if(ret1 == null || ret2 == null)  return "无该用户";
        if(ret1 < order.getValue())return "用户金额不足";
        userMapper.changeMoney(order.getBuyerId(), ret1 - order.getValue());
        userMapper.changeMoney(order.getSellerId(), ret2 + order.getValue());
        int ret = orderMapper.insertOrder(order);
        if(ret <= 0) return "交易失败";
        objectMapper.updateObject(order.getBuyerId(), order.getObjectId());
        return "交易成功";
    }

    public List<OrderDetail> showOrder(Integer userId) {
        return orderMapper.getOrderDetails(userId);
    }
}
