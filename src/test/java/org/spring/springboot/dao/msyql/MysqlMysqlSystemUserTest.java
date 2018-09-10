package org.spring.springboot.dao.msyql;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.spring.springboot.Application;
import org.spring.springboot.dao.mysql.MysqlUserDao;
import org.spring.springboot.dao.postgresql.PostgresqlUserDao;
import org.spring.springboot.domain.MysqlSystemUser;
import org.spring.springboot.domain.PostgresqlSystemUser;
import org.spring.springboot.service.mysql.MysqlUserService;
import org.spring.springboot.service.postgresql.PostgresqlUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/7/9 15:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MysqlMysqlSystemUserTest {
    @Autowired
    private MysqlUserDao mysqlUserDao;

    @Autowired
    private MysqlUserService mysqlUserService;

    @Test
    public void queryTest() throws Exception {
        List<Map<String, Object>> mapList = mysqlUserDao.queryList();
        for(Map<String, Object> map : mapList) {
            System.out.print("[");
            for (Map.Entry<String, Object> entry : map.entrySet()) {
//                System.out.print(entry.getKey() + ":" + entry.getValue() + ",");
                System.out.print(entry.getKey() + ":" + ",");
            }
            System.out.println("]");
        }
    }
    @Test
    public void insertTest() throws Exception {
        MysqlSystemUser postgresqlSystemUser = new MysqlSystemUser();
        postgresqlSystemUser.setUsername("111");
        postgresqlSystemUser.setPassword("password");
        postgresqlSystemUser.setNickname("nickname");
        postgresqlSystemUser.setGender(1);
        postgresqlSystemUser.setEnable(1);
        System.out.println(mysqlUserDao.insert(postgresqlSystemUser));
    }

    @Test
    public void transactionalTest() throws Exception {
        mysqlUserService.transactionalTest();
    }
}