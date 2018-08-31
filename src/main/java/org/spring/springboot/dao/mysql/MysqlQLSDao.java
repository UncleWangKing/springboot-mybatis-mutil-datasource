package org.spring.springboot.dao.mysql;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MysqlQLSDao {
    List<Map<String,Object>> queryList();

    Boolean update(@Param("item") Map<String,Object> item);
}
