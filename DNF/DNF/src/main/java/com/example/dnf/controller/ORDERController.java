package com.example.dnf.controller;

import com.example.dnf.entity.Order;
import com.example.dnf.entity.OrderDetail;
import com.example.dnf.service.ORDERService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ORDERController {
    @Autowired
    ORDERService orderService;

    @RequestMapping("/insertOrder")
    public String insertOrder(Order order){
        return orderService.insertOrder(order);
    }

    @RequestMapping(value = "/showOrder", method = RequestMethod.GET)
    public OrderDetail showOrder(Integer orderId){
        return orderService.showOrder(orderId);
    }
}