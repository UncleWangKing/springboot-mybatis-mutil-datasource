package org.spring.springboot.service.postgresql;

import org.spring.springboot.dao.postgresql.PostgresqlUserDao;
import org.spring.springboot.domain.PostgresqlSystemUser;
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
        PostgresqlSystemUser postgresqlSystemUser = new PostgresqlSystemUser();
        postgresqlSystemUser.setName("111");
        System.out.println(postgresqlUserDao.insert(postgresqlSystemUser));
        if(true)
            throw new RuntimeException();
        postgresqlSystemUser.setName("222");
        System.out.println(postgresqlUserDao.insert(postgresqlSystemUser));
    }
}
