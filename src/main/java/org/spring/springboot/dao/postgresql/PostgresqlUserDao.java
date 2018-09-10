package org.spring.springboot.dao.postgresql;

import org.apache.ibatis.annotations.Mapper;
import org.spring.springboot.domain.SystemUser;

import java.util.List;
import java.util.Map;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/6/29 11:25
 */
@Mapper
public interface PostgresqlUserDao {

    List<Map<String,Object>> queryList();

    Boolean insert(SystemUser systemUser);
}
