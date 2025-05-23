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
        return administratorService.insertAdministrator(administrator);
    }

    @RequestMapping(value = "/showAdministrator", method = RequestMethod.GET)
    public List<Administrator> getAllAdministrator() {
        return administratorService.showAdministrator();
    }
}
