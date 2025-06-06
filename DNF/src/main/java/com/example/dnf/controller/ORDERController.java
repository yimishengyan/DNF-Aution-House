package com.example.dnf.controller;

import com.example.dnf.entity.Order;
import com.example.dnf.entity.OrderDetail;
import com.example.dnf.entity.User;
import com.example.dnf.service.ORDERService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ORDERController {
    @Autowired
    ORDERService orderService;

    @RequestMapping("/insertOrder")
    public String insertOrder(@RequestBody Order order){
        System.out.println("购买物品订单信息" + order);
        return orderService.insertOrder(order);
    }

    @RequestMapping(value = "/showOrder", method = RequestMethod.POST)
    public List<OrderDetail> showOrder(@RequestBody User user){
        System.out.println("展示订单时，用户信息" + user);
        return orderService.showOrder(user.getUserId());
    }
}