package org.spring.springboot.dao.mysql;

import org.apache.ibatis.annotations.Mapper;
import org.spring.springboot.domain.MysqlSystemUser;
import org.spring.springboot.domain.PostgresqlSystemUser;

import java.util.List;
import java.util.Map;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/6/29 11:25
 */
@Mapper
public interface MysqlUserDao {

    List<Map<String,Object>> queryList();

    Boolean insert(MysqlSystemUser mysqlSystemUser);
}
