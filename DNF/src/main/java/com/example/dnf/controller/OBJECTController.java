package com.example.dnf.controller;

import com.example.dnf.entity.Object;
import com.example.dnf.entity.ObjectDetail;
import com.example.dnf.entity.User;
import com.example.dnf.service.OBJECTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class OBJECTController {
    @Autowired
    private OBJECTService objectService;


    @RequestMapping(value = "/insertObject", method = RequestMethod.POST)
    public String insertObject(@RequestParam Object object) {
        return objectService.insertObject(object);
    }

    @RequestMapping(value = "/countObject", method = RequestMethod.GET)
    public int countObject(Object object) {
        return objectService.countObject(object.getName());
    }

    @RequestMapping(value = "/minValue", method = RequestMethod.GET)
    public double minValue(Object object) {
        return objectService.minValue(object.getName());
    }

    @RequestMapping(value = "/showObject", method = RequestMethod.POST)
    public List<ObjectDetail> showObject(@RequestBody Object object) {
        System.out.println("展示物品大类" + object);
        return objectService.showObject(object.getType());
    }

    @RequestMapping(value = "/showSingleObject", method = RequestMethod.GET)
    public List<Object> showSingleObject(Object object){
        System.out.println("展示具体物品" + object);
        return objectService.showSingleObject(object.getName());
    }

    @RequestMapping(value = "/showUserObject", method = RequestMethod.GET)
    public List<Object> showUserObject(@RequestParam Integer userId) {
        System.out.println("展示用户拥有的物品" + userId);
        List<Object> objects = objectService.showUserObject(userId);
        System.out.println("ret" + objects);
        return objects;
    }
}
