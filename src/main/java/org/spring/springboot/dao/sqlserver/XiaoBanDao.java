package org.spring.springboot.dao.sqlserver;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.XiaoBan;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/6/29 11:25
 */
@Mapper
public interface XiaoBanDao {


    XiaoBan queryById(@Param("id") Integer id);
}
