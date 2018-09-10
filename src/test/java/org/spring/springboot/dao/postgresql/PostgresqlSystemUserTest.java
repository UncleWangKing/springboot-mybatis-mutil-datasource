package org.spring.springboot.dao.postgresql;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.spring.springboot.Application;
import org.spring.springboot.dao.mysql.MysqlQLSDao;
import org.spring.springboot.domain.SystemUser;
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
public class PostgresqlSystemUserTest {
    @Autowired
    private PostgresqlUserDao postgresqlUserDao;

    @Test
    public void queryTest() throws Exception {
        List<Map<String, Object>> mapList = postgresqlUserDao.queryList();
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
        SystemUser systemUser = new SystemUser();
        systemUser.setName("haha");
        System.out.println(postgresqlUserDao.insert(systemUser));
    }
}