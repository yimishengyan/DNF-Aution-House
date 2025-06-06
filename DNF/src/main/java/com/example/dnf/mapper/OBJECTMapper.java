package com.example.dnf.mapper;

import com.example.dnf.entity.Object;
import com.example.dnf.entity.ObjectDetail;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OBJECTMapper {
    @Options(useGeneratedKeys = true, keyProperty = "objectId", keyColumn = "objectId")
    @Insert("INSERT INTO object (name, type, value, ownerId, path) VALUES (#{name}, #{type}, #{value}, #{ownerId}, #{path})")
    public int insertObject(Object object);

    @Select("SELECT COUNT(*) FROM object where name = #{name}")
    public int countObject(String name);

    @Select("SELECT MIN(value) FROM object WHERE name = #{name}")
    public double minValue(String name);

    @Select("SELECT * FROM object where name =  #{name}")
    public List<Object> showSingleObject(String name);

    @Select("SELECT MIN(objectId) AS objectId, name, COUNT(*) AS count, MIN(value) AS value " +
            "FROM object " +
            "WHERE type = #{type} " +
            "GROUP BY name")
    List<ObjectDetail> showObject(String type);

    @Update("UPDATE object SET ownerId = #{ownerId} WHERE objectId = #{objectId}")
    public int updateObject(Integer ownerId, Integer objectId);

    @Select("SELECT * FROM object WHERE ownerId = #{ownerId}")
    public List<Object> showUserObject(Integer ownerId);

    @Delete("DELETE FROM object WHERE ownerId = #{ownerId}")
    public int deleteObject(Integer ownerId);

}
