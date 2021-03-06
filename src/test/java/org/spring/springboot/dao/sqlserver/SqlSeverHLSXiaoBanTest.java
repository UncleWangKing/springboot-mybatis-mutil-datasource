package org.spring.springboot.dao.sqlserver;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.spring.springboot.Application;
import org.spring.springboot.dao.mysql.MysqlXiaoBanDao;
import org.spring.springboot.domain.HLSXiaoBan;
import org.spring.springboot.util.PositionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/6/29 15:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SqlSeverHLSXiaoBanTest {
    @Autowired
    private MysqlXiaoBanDao mysqlXiaoBanDao; // 主数据源

    @Autowired
    private SqlServerXiaoBanDao sqlServerXiaoBanDao; // 从数据源

    @Test
    public void queryById() throws Exception {
        HLSXiaoBan xb = sqlServerXiaoBanDao.queryById(1);
        System.out.println(xb);
    }

    @Test
    public void queryList() throws Exception {
        List<HLSXiaoBan> list = sqlServerXiaoBanDao.queryList();
        System.out.println(list.size());
    }

    @Test
    public void batchSave() throws Exception {
        List<HLSXiaoBan> list = new ArrayList<HLSXiaoBan>();
        HLSXiaoBan xb = sqlServerXiaoBanDao.queryById(1);
        PositionUtil.setFourPos(xb);
        list.add(xb);
        HLSXiaoBan xb2 = sqlServerXiaoBanDao.queryById(2);
        list.add(xb2);
        PositionUtil.setFourPos(xb2);
        mysqlXiaoBanDao.batchSave(list);
//        mysqlXiaoBanDao.saveAnimalAll(xb);
    }

    @Test
    public void transfer() throws Exception {
        List<HLSXiaoBan> resultList = sqlServerXiaoBanDao.queryList();
        resultList.forEach(item->PositionUtil.setFourPos(item));
        int i = 0;
        int step = 1000;
        while (i*step < resultList.size()) {
            List<HLSXiaoBan> saveList = null;
            if(i*step + step < resultList.size())
                saveList = resultList.subList(i*step, i*step + step);
            else
                saveList = resultList.subList(i*step, resultList.size());
            mysqlXiaoBanDao.batchSave(saveList);
            System.out.println(i*step + "-" + (i+1)*step +" 条入库");
            i++;
        }
    }
}