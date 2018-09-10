package org.spring.springboot.dao.msyql;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.spring.springboot.Application;
import org.spring.springboot.dao.mysql.MysqlQLSDao;
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
public class MysqlQLSTest {
    @Autowired
    private MysqlQLSDao mysqlQLSDao;

    /**
     * MwEditState:,MwUserID:,YDXIAN_N:,
     * MwMaxX:,MwMaxY:,ALT:,YDDCSXH:,JSJSSJ:,
     * MwOID:,MwGeometry:,MwCheckedUserID:,YDH:,
     * DCRQ:,MwMinX:,MwMinY:,KSJSSJ:,YDS:,LON:,
     * YDJD:,YDHB:,NAME:,YDXIAN:,YDXIANG:,
     * YDXDM:,YDWD:,YDS_N:,LAT:,
     */
    @Test
    public void queryTest() throws Exception {
        List<Map<String, Object>> mapList = mysqlQLSDao.queryList();
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
    public void updateTest() throws Exception {
        List<Map<String, Object>> mapList = mysqlQLSDao.queryList();
        for(Map<String, Object> map : mapList) {
            System.out.println(mysqlQLSDao.update(map));
        }
    }
}