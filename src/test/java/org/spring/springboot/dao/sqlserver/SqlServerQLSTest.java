package org.spring.springboot.dao.sqlserver;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.spring.springboot.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/7/9 15:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SqlServerQLSTest {
    @Autowired
    private SqlSeverQLSDao sqlSeverQLSDao;

    /**
     * MwEditState:,MwUserID:,YDXIAN_N:,
     * MwMaxX:,MwMaxY:,ALT:,YDDCSXH:,JSJSSJ:,
     * MwOID:,MwGeometry:,MwCheckedUserID:,YDH:,
     * DCRQ:,MwMinX:,MwMinY:,KSJSSJ:,YDS:,LON:,
     * YDJD:,YDHB:,NAME:,YDXIAN:,YDXIANG:,
     * YDXDM:,YDWD:,YDS_N:,LAT:,
     */
    @Test
    public void queryById() throws Exception {
        List<Map<String, Object>> mapList = sqlSeverQLSDao.queryList();
        for(Map<String, Object> map : mapList) {
            System.out.print("[");
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                System.out.print(entry.getKey() + ":" + entry.getValue() + ",");
//                System.out.print(entry.getKey() + ":" + ",");
            }
            System.out.println("]");
        }
    }

    @Test
    public void animalTest() throws Exception {
        List<Map<String, Object>> mapList = sqlSeverQLSDao.queryAnimalList();
        int index = 1;
        Random random = new Random();
        for(Map<String, Object> map : mapList) {
            map.put("MwOID", index++);
            String StrD ="2014-04-20 11:22:45";
            SimpleDateFormat sdfd =new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
            Date dat =sdfd.parse(StrD);
            dat.setTime(dat.getTime() + ((long) random.nextInt(6))*60l*60*60*10*365*24);
            map.put("recordDate",dat);
            map.put("number", random.nextInt(1500) + random.nextInt(100));
            map.put("suoshubaohuqu", "甘肃祁连山国家级自然保护区");
            sqlSeverQLSDao.saveAnimalAll(map);
        }
    }

    @Test
    public void plantTest() throws Exception {
        List<Map<String, Object>> mapList = sqlSeverQLSDao.queryPlantList();
        int index = 1;
        Random random = new Random();
        for(Map<String, Object> map : mapList) {
            map.put("MwOID", index++);
            map.put("KeyID", index);
            String StrD ="2014-04-20 11:22:45";
            SimpleDateFormat sdfd =new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
            Date dat =sdfd.parse(StrD);
            dat.setTime(dat.getTime() + ((long) random.nextInt(6))*60l*60*60*10*365*24);
            map.put("recordDate",dat);
//            String [] numbers = {"稀少","极其稀少","不多","较多"};
            map.put("zhushu", random.nextInt(1000));
            map.put("suoshubaohuqu", "甘肃祁连山国家级自然保护区");
            sqlSeverQLSDao.savePlantAll(map);
        }
    }
}