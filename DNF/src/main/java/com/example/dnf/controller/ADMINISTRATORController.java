package com.example.dnf.controller;

import com.example.dnf.entity.Administrator;
import com.example.dnf.service.ADMINISTRATORService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ADMINISTRATORController {
    @Autowired
    ADMINISTRATORService administratorService;

    @RequestMapping(value = "/insertAdministrator", method = RequestMethod.POST)
    public String insertAdministrator(@RequestBody Administrator administrator) {
        if(administratorService.sllectAdministratorName(administrator.getName()) == 0)
            return administratorService.insertAdministrator(administrator);
        System.out.println("接收到的 type: " + administrator);
        return "管理员已存在，请修改用户名";
    }

    @RequestMapping(value = "/showAdministrator", method = RequestMethod.GET)
    public List<Administrator> getAllAdministrator() {
        return administratorService.showAdministrator();
    }

    @RequestMapping(value = "/selectAdministrator", method = RequestMethod.POST)
    String selectAdministratorPassword(@RequestBody Administrator administrator){
        System.out.println("接收到的 type: " + administrator);
        return administratorService.selectAdministratorPassword(administrator);
    }
}
