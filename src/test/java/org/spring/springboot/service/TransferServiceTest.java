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

import java.math.BigDecimal;
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
        xb.setShape(xb.getShape()
                .replace("POLYGON ((", "")
                .replace("((", "")
                .replace("))", "")
                .replace(")", "")
                .replace("(", ""));
        list.add(xb);
//        XiaoBan xb2 = sqlServerXiaoBanDao.queryById(2);
//        xb2.setShape(xb2.getShape().replace("POLYGON ((", "").replace("))", ""));
//        list.add(xb2);
//        mysqlXiaoBanDao.batchSave(list);
//        mysqlXiaoBanDao.save(xb);
    }

    @Test
    public void transfer() throws Exception {
        List<XiaoBan> resultList = sqlServerXiaoBanDao.queryList();
        resultList.forEach(item->item.setShape(item.getShape()
                .replace("POLYGON ((", "")
                .replace("((", "")
                .replace("))", "")
                .replace(")", "")
//                .replace("P", "")
                .replace("(", "")));
        resultList.forEach(item->setFourPos(item));
        int i = 0;
        int step = 1000;
        while (i*step < resultList.size()) {
            List<XiaoBan> saveList = null;
            if(i*step + step < resultList.size())
                saveList = resultList.subList(i*step, i*step + step);
            else
                saveList = resultList.subList(i*step, resultList.size());
            mysqlXiaoBanDao.batchSave(saveList);
            System.out.println(i*step + "-" + (i+1)*step +" 条入库");
            i++;
        }
    }

    public void setFourPos(XiaoBan xiaoban){
        String str = xiaoban.getShape();
        if(str.contains("P") || str.contains("p"))
            System.out.println(111);
        BigDecimal maxX = new BigDecimal(Double.MIN_VALUE);
        BigDecimal maxY = new BigDecimal(Double.MIN_VALUE);
        BigDecimal minX = new BigDecimal(Double.MAX_VALUE);
        BigDecimal minY = new BigDecimal(Double.MAX_VALUE);
        String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            String tempStr = split[i];
            String[] tempSplit = tempStr.split(" ");
            String[] finalSplit = new String[2];
            if("".equals(tempSplit[0]))
                System.arraycopy(tempSplit, 1, finalSplit, 0, 2);
            else
                finalSplit = tempSplit;


            for (int j = 0; j < finalSplit.length; j++) {
                BigDecimal temp = new BigDecimal(finalSplit[j]);
                if(0 == j){//x
                    maxX = maxX.max(temp);
                    minX = minX.min(temp);
                }else {//y
                    maxY = maxY.max(temp);
                    minY = minY.min(temp);
                }
            }
        }
        xiaoban.setMaxX(maxX);
        xiaoban.setMinX(minX);
        xiaoban.setMaxY(maxY);
        xiaoban.setMinY(minY);
//        return maxY.toString() + "," + maxX.toString() + "," + minY.toString() + "," + minX.toString();
    }
}