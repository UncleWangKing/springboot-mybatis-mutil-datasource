package org.spring.springboot.dao.mysql;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.User;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/6/29 11:25
 */
@Mapper
public interface UserDao {

    /**
     * 根据用户名获取用户信息
     *
     * @param id
     * @return
     */
    User findByName(@Param("id") Integer id);
}
