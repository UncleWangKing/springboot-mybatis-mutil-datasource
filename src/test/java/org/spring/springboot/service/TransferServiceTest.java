package org.spring.springboot.service;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.spring.springboot.Application;
import org.spring.springboot.dao.mysql.MysqlXiaoBanDao;
import org.spring.springboot.dao.sqlserver.SqlServerXiaoBanDao;
import org.spring.springboot.domain.XiaoBan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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
public class TransferServiceTest {
    @Autowired
    private MysqlXiaoBanDao mysqlXiaoBanDao; // 主数据源

    @Autowired
    private SqlServerXiaoBanDao sqlServerXiaoBanDao; // 从数据源

    @Test

    public void queryById() throws Exception {
        XiaoBan xb = sqlServerXiaoBanDao.queryById(1);
        System.out.println(xb);
    }

    @Test
    public void queryList() throws Exception {
        List<XiaoBan> list = sqlServerXiaoBanDao.queryList();
        System.out.println(list.size());
    }

    @Test
    public void batchSave() throws Exception {
        List<XiaoBan> list = new ArrayList<XiaoBan>();
        XiaoBan xb = sqlServerXiaoBanDao.queryById(1);
        xb.setShape(xb.getShape().replace("POLYGON ((", "").replace("))", ""));
        list.add(xb);
        XiaoBan xb2 = sqlServerXiaoBanDao.queryById(2);
        xb2.setShape(xb2.getShape().replace("POLYGON ((", "").replace("))", ""));
        list.add(xb2);
        mysqlXiaoBanDao.batchSave(list);
    }

    @Test
    public void transfer() throws Exception {
        List<XiaoBan> resultList = sqlServerXiaoBanDao.queryList();
        resultList.forEach(item->item.setShape(item.getShape().replace("POLYGON ((", "").replace("))", "")));

        int i = 0;
        int step = 1000;
        while (i*step < resultList.size()) {
            List<XiaoBan> saveList = null;
            if(i*step + step < resultList.size())
                saveList = resultList.subList(i*step, i*step + step);
            else
                saveList = resultList.subList(i*step, resultList.size());
            mysqlXiaoBanDao.batchSave(saveList);
            System.out.println(i*1000 + "-" + (i+1)*1000 +" 条入库");
            i++;
        }
    }

}