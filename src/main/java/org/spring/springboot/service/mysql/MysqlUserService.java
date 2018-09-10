package org.spring.springboot.service.mysql;

import org.spring.springboot.dao.mysql.MysqlUserDao;
import org.spring.springboot.domain.MysqlSystemUser;
import org.spring.springboot.domain.PostgresqlSystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/9/10 16:18
 */
@Service
public class MysqlUserService {
    @Autowired
    MysqlUserDao mysqlUserDao;

    @Transactional
    public void transactionalTest(){
        MysqlSystemUser postgresqlSystemUser = new MysqlSystemUser();
        postgresqlSystemUser.setUsername("111");
        postgresqlSystemUser.setPassword("password");
        postgresqlSystemUser.setNickname("nickname");
        postgresqlSystemUser.setGender(1);
        postgresqlSystemUser.setEnable(1);
        System.out.println(mysqlUserDao.insert(postgresqlSystemUser));
        if(true)
            throw new RuntimeException();
        postgresqlSystemUser.setUsername("222");
        System.out.println(mysqlUserDao.insert(postgresqlSystemUser));
    }
}
