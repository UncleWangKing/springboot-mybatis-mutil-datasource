package org.spring.springboot.dao.sqlserver;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.HLSLinBan;

import java.util.List;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/6/29 11:25
 */
@Mapper
public interface SqlServerLinBanDao {


    HLSLinBan queryById(@Param("id") Integer id);

    List<HLSLinBan> queryList();
}
