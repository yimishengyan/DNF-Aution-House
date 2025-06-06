package com.example.dnf.service;

import com.example.dnf.entity.Object;
import com.example.dnf.entity.ObjectDetail;
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

    public int countObject(String name){
        return objectMapper.countObject(name);
    }

    public double minValue(String name){
        return objectMapper.minValue(name);
    }

    public List<ObjectDetail> showObject(String type){
        return objectMapper.showObject(type);
    }

    public List<Object> showSingleObject(String name){
        return objectMapper.showSingleObject(name);
    }

    public List<Object> showUserObject(Integer userId){
        return objectMapper.showUserObject(userId);
    }
}
