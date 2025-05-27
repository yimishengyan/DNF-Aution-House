package com.example.dnf.mapper;

import com.example.dnf.entity.Administrator;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ADMINISTRATORMapper {
    @Options(useGeneratedKeys = true, keyProperty = "administratorId", keyColumn = "administratorId")
    @Insert("INSERT INTO administrator (name, password) VALUES (#{name}, #{password})")
    public int insertAdministrator(Administrator administrator);

    @Select("select * from administrator")
    public List<Administrator> showAdministrator();
}
