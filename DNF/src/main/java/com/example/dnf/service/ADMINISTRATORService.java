package com.example.dnf.service;

import com.example.dnf.entity.Administrator;
import com.example.dnf.mapper.ADMINISTRATORMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ADMINISTRATORService {
    @Autowired
    private ADMINISTRATORMapper administratorMapper;

    public String insertAdministrator(Administrator administrator) {
        int ret = administratorMapper.insertAdministrator(administrator);
        System.out.println("回填的 administrator_id: " + administrator.getAdministratorId());
        return ret > 0 ? "创建成功" : "创建失败";
    }

    public List<Administrator> showAdministrator() {
        return administratorMapper.showAdministrator();
    }
}
