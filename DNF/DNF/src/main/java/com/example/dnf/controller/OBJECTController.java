package com.example.dnf.controller;

import com.example.dnf.entity.Object;
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
    public int countObject(String type){
        return objectService.countObject(type);
    }

    @RequestMapping(value = "/minValue", method = RequestMethod.GET)
    public double minValue(String type){
        return objectService.minValue(type);
    }

    @RequestMapping(value = "/showObject", method = RequestMethod.GET)
    public List<Object> showObject(String type){
        return objectService.showObject(type);
    }
}
