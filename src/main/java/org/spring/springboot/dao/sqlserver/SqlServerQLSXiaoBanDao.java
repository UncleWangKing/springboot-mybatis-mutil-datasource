package org.spring.springboot.dao.sqlserver;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.HLSXiaoBan;
import org.spring.springboot.domain.QLSXiaoBan;

import java.util.List;
import java.util.Map;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/6/29 11:25
 */
@Mapper
public interface SqlServerQLSXiaoBanDao {


    Map<String, Object> queryById(@Param("id") Integer id);

    List<QLSXiaoBan> queryList();
}
