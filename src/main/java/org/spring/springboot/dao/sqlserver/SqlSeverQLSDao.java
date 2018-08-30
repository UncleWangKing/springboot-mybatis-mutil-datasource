package org.spring.springboot.dao.sqlserver;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface SqlSeverQLSDao {
    List<Map<String,Object>> queryList();

    List<Map<String,Object>> queryAnimalList();

    List<Map<String,Object>> queryPlantList();

    Boolean saveAnimalAll(@Param("item") Map<String, Object> item);

    Boolean savePlantAll(@Param("item") Map<String, Object> item);
}
