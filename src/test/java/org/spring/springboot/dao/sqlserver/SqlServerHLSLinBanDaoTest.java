package org.spring.springboot.dao.sqlserver;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.spring.springboot.Application;
import org.spring.springboot.dao.mysql.MysqlLinBanDao;
import org.spring.springboot.domain.HLSLinBan;
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
public class SqlServerHLSLinBanDaoTest {
    @Autowired
    private MysqlLinBanDao mysqlLinBanDao; // 主数据源

    @Autowired
    private SqlServerLinBanDao sqlServerLinBanDao; // 从数据源

    @Test
    public void queryById() throws Exception {
        HLSLinBan lb = sqlServerLinBanDao.queryById(1);
        System.out.println(lb);
        PositionUtil.setFourPos(lb);
        mysqlLinBanDao.save(lb);
    }

    @Test
    public void transfer() throws Exception {
        List<HLSLinBan> resultList = sqlServerLinBanDao.queryList();
        resultList.forEach(item->PositionUtil.setFourPos(item));
        int i = 0;
        int step = 100;
        while (i*step < resultList.size()) {
            List<HLSLinBan> saveList = null;
            if(i*step + step < resultList.size())
                saveList = resultList.subList(i*step, i*step + step);
            else
                saveList = resultList.subList(i*step, resultList.size());
            mysqlLinBanDao.batchSave(saveList);
            System.out.println(i*step + "-" + (i+1)*step +" 条入库");
            i++;
        }
    }
}