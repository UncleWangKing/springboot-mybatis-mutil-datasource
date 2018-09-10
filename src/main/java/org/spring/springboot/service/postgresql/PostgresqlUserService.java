package org.spring.springboot.service.postgresql;

import org.spring.springboot.dao.postgresql.PostgresqlUserDao;
import org.spring.springboot.domain.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/9/10 16:18
 */
@Service
public class PostgresqlUserService {
    @Autowired
    PostgresqlUserDao postgresqlUserDao;

    @Transactional
    public void transactionalTest(){
        SystemUser systemUser = new SystemUser();
        systemUser.setName("111");
        System.out.println(postgresqlUserDao.insert(systemUser));
        if(true)
            throw new RuntimeException();
        systemUser.setName("222");
        System.out.println(postgresqlUserDao.insert(systemUser));
    }
}
