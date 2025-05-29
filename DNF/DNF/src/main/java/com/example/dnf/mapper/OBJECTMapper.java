package com.example.dnf.mapper;

import com.example.dnf.entity.Object;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OBJECTMapper {
    @Options(useGeneratedKeys = true, keyProperty = "objectId", keyColumn = "objectId")
    @Insert("INSERT INTO object (name, type, value, ownerId, path)")
    public int insertObject(Object object);

    @Select("SELECT COUNT(*) FROM object where type = #{type}")
    public int countObject(String type);

    @Select("SELECT MIN(value) FROM object WHERE type = #{typr}")
    public double minValue(String type);

    @Select("SELECT * FROM object where type =  #{type}")
    public List<Object> showObject(String type);
}
