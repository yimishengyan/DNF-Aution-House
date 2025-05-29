package com.example.dnf.service;

import com.example.dnf.entity.Object;
import com.example.dnf.mapper.OBJECTMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OBJECTService {
    @Autowired
    OBJECTMapper objectMapper;

    public String insertObject(Object object) {
        int ret = objectMapper.insertObject(object);
        return ret > 0 ? "添加成功" : "添加失败";
    }

    public int countObject(String type){
        return objectMapper.countObject(type);
    }

    public double minValue(String type){
        return objectMapper.minValue(type);
    }

    public List<Object> showObject(String type){
        return objectMapper.showObject(type);
    }
}
