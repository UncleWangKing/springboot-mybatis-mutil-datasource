package org.spring.springboot.dao.sqlserver;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.spring.springboot.Application;
import org.spring.springboot.dao.mysql.MysqlLinBanDao;
import org.spring.springboot.domain.LinBan;
import org.spring.springboot.util.PositionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/7/9 15:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SqlServerReplaceWholeDBDaoTest {
    @Autowired
    private SqlServerReplaceWholeDBDao sqlServerReplaceWholeDBDao; // 主数据源

    @Test
    public void queryAllTableName() throws Exception {
        List<String> strings = sqlServerReplaceWholeDBDao.queryAllTableName();
        strings.forEach(System.out::println);
    }
}